# CS 122 Setup Check

Exam setup verification. Everything stays local on the machine.

This verifies five things:

- VS Code can render markdown
- VS Code can compile and run a Java file
- JUnit 4 jars can be added to the project classpath
- VS Code can run JUnit tests and show green checkmarks
- Respondus LockDown Browser is installed and ready

## Step 1: Create a Local Folder

Create a new folder anywhere on the local machine, name it `setup-check`. Open it in VS Code: **File → Open Folder**, choose the folder. Click "Yes, I trust the authors" if prompted.

## Step 2: Verify Markdown Preview

Inside the folder, create a file named `README.md`. Paste:

```
# Test Header
This text is **bold** when previewed.
```

Save. Right-click `README.md` in the file explorer and choose **Open Preview** (or press Cmd/Ctrl + Shift + V). The header should render large and the word "bold" should appear bold.

## Step 3: Verify Java Compile and Run

Inside the folder, create `SetupCheck.java` and paste:

```java
public class SetupCheck {

    public static int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        System.out.println("VS Code Java setup is working.");
        System.out.println("Sample sum: " + add(2, 3));
    }
}
```

Save. Run it using either:

1. Click the **Run** link that appears above `main`
2. Click the dropdown next to the play button at the top right of the editor, choose **Run Java** or **Run Code**

The terminal panel should print:

```
VS Code Java setup is working.
Sample sum: 5
```

At least one method should produce that output. If both **Run Java** and **Run Code** fail, see Troubleshooting.

## Step 4: Add JUnit 4 to the Project Classpath

JUnit is not part of the JDK, so it has to be added to the project manually. The class uses **JUnit 4** to match the lab convention. Ignore any VS Code prompts that point to JUnit 5 / Jupiter — those are not what is needed here.

### Download the two required jars

Click each link in a browser to download the jar:

1. **junit-4.13.2.jar**
   https://repo1.maven.org/maven2/junit/junit/4.13.2/junit-4.13.2.jar

2. **hamcrest-core-1.3.jar** (required by JUnit 4's assertion methods)
   https://repo1.maven.org/maven2/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar

**Save both jars to a permanent folder** — not Downloads, not Desktop. Downloads gets cleaned out on most machines, and the classpath stores absolute paths. If those files disappear later, the classpath silently breaks. Recommend creating a `junit-libs` folder in the home directory or Documents, and dropping both jars there. The same jars get reused for the exam project.

### Add the jars to this project's classpath

1. Open the Command Palette: **Cmd/Ctrl + Shift + P**
2. Type: `Java: Configure Classpath`
3. Select that command. A "Project Settings" panel opens.
4. In the left sidebar of that panel, click **Classpath**, then in the top tabs, click **Libraries**
5. Click **+ Add Library...**
6. Navigate to where the jars were saved
7. Select both `junit-4.13.2.jar` and `hamcrest-core-1.3.jar` (hold Cmd/Ctrl to select both)
8. Click **Open**

Both jar paths should now appear in the Libraries list.

### Create the test file

Inside the `setup-check` folder, create `SetupCheckTest.java` and paste:

```java
import org.junit.Test;
import static org.junit.Assert.*;

public class SetupCheckTest {

    @Test
    public void testAddBasic() {
        assertEquals(5, SetupCheck.add(2, 3));
    }

    @Test
    public void testAddZero() {
        assertEquals(7, SetupCheck.add(7, 0));
    }
}
```

Save.

## Step 5: Run the JUnit Tests

**Run Test** links should appear above each `@Test` annotation (small green play arrow icons in the gutter). Click **Run Test** on either method.

**Look at the TEST RESULTS panel.** Two green checkmarks next to `testAddBasic()` and `testAddZero()` means JUnit is working and the setup is exam-ready.

### About the red squigglies on the imports

After adding the jars, the imports `org.junit.Test` and `org.junit.Assert` may **still show red squigglies** with "package org.junit does not exist" errors, even though the tests run green.

**This is a known VS Code stale-cache issue, not a broken setup.** The Test Runner has the classpath, but the Java Language Server (the part doing syntax checking) hasn't picked up the jars yet.

**The success criterion is green checkmarks in TEST RESULTS, not the absence of red squigglies.** If the tests run green, JUnit is configured correctly.

To clear the squigglies (escalating fixes):

1. **Reload the window**: Cmd/Ctrl + Shift + P → "Developer: Reload Window". Usually clears it within 5 seconds.
2. **Clean the language server workspace**: Cmd/Ctrl + Shift + P → "Java: Clean Java Language Server Workspace" → click "Restart and delete". Wait about 10 seconds for re-indexing. This almost always works.
3. **Quit and reopen VS Code entirely.**

## Step 6: LockDown Browser

The exam runs through Respondus LockDown Browser. Without it installed, the exam will not start.

### Install

Download from this link:
https://download.respondus.com/lockdown/download.php?ID=222638733

- **Mac**: open the .dmg, drag the app into Applications
- **Windows**: run the installer and follow the prompts

### Launch from Brightspace on Exam Day

1. Log in to Brightspace
2. Navigate to: **Class → Activities → Quizzes**
3. Click the exam quiz
4. The "Quiz Requirements" page shows two items:
   - A link to download and install LockDown Browser (skip if installed in the step above)
   - A blue **Launch LockDown Browser** button — click this to start the exam

## On Exam Day

The exam folder will be a separate project. To use the same JUnit jars there:

1. Open the exam folder in VS Code
2. Cmd/Ctrl + Shift + P → "Java: Configure Classpath" → Libraries tab → Add Library
3. Select the same two jars from the permanent folder where they were saved

About 30 seconds. The jars are already downloaded.

## Troubleshooting

**No Run / Run Test links appearing, both Run Java and Run Code fail**

- Open Extensions sidebar (Cmd/Ctrl + Shift + X)
- Search "Extension Pack for Java" by Microsoft
- Confirm installed AND enabled (the full bundle, not just one extension from it)
- Reload window: Cmd/Ctrl + Shift + P → "Developer: Reload Window"

**Java not found**

- Open terminal (View → Terminal)
- Run `java -version` and `javac -version`
- Both should return version numbers
- If not, the JDK is missing or not on PATH

**Tests fail to RUN (not just squiggly red — actually fail to execute)**

- Confirm BOTH jars were added (junit AND hamcrest); JUnit 4 needs both
- Confirm the imports are exactly `org.junit.Test` and `org.junit.Assert` (NOT `org.junit.jupiter.*` — that is JUnit 5 and will not work with these jars)
- Reload the window or clean the language server workspace (see Step 5)

**Run Test link does not appear above @Test**

- Confirm the test class is `public`
- Reload the window
