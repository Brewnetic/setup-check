# CS 122 Setup Check

Final exam setup verification. Confirm everything works before exam start. Walking in with a broken setup is not the move.

This repo verifies four things:
- VS Code can render markdown
- VS Code can compile and run a Java file
- VS Code can run JUnit tests
- Respondus LockDown Browser is installed and ready to launch from Brightspace

## Step 1: Clone This Repo

In GitHub Desktop:
- File → Clone Repository → URL tab
- Paste: `https://github.com/CS122-OOP-Spring-2026/setup-check`
- Choose a local folder, click Clone

Do not use the browser's "Open with GitHub Desktop" button. It is unreliable. Always clone from inside the GitHub Desktop app.

## Step 2: Open in VS Code

Open the cloned `setup-check` folder in VS Code. Click "Yes, I trust the authors" if prompted.

## Step 3: Verify Markdown Preview

If this README is rendering with formatted headers and **bold text**, the markdown preview is already working.

If it shows as raw text instead, right-click on `README.md` in the file explorer and choose "Open Preview" (or press Cmd/Ctrl + Shift + V).

## Step 4: Run a Java File

Open `SetupCheck.java`. Click the **Run** link that appears above the `main` method. The terminal panel should print:

```
VS Code Java setup is working.
Sample sum: 5
```

If no Run link appears above `main`, the Extension Pack for Java is missing or inactive. See Troubleshooting below.

## Step 5: Run a JUnit Test

Open `SetupCheckTest.java`. Click **Run Test** above any `@Test` annotation. Two green checkmarks should appear in the Test Results panel.

If the imports show red squigglies or the test does not run, see Troubleshooting below.

## Step 6: LockDown Browser

The final exam runs through Respondus LockDown Browser. Without it installed, the exam will not start.

### Install

Download from this link:
https://download.respondus.com/lockdown/download.php?ID=222638733

- **Mac**: open the .dmg, drag the app into Applications
- **Windows**: run the installer and follow the prompts

### Launch from Brightspace on Exam Day

1. Log in to Brightspace
2. Navigate to: **Class → Activities → Quizzes**
3. Click the final exam quiz
4. The "Quiz Requirements" page shows two items:
   - A link to download and install LockDown Browser (skip if already installed in the step above)
   - A blue **Launch LockDown Browser** button — click this to start the exam

Once launched, LockDown Browser locks down the system: no other apps, no copy/paste from outside, no other browser tabs. The exam runs entirely inside it.

## Troubleshooting

**No Run or Run Test buttons in VS Code**
- Open Extensions sidebar (Cmd/Ctrl + Shift + X)
- Search "Extension Pack for Java" by Microsoft
- Confirm installed AND enabled (the full bundle, not just one extension from it)
- Reload window: Cmd/Ctrl + Shift + P → "Developer: Reload Window"

**Java not found**
- Open Terminal (View → Terminal)
- Run `java -version` and `javac -version`
- Both should return version numbers
- If not, the JDK is missing or not on PATH

**JUnit imports show as unresolved (red squigglies on the import lines)**
- Click the lightbulb icon next to the red squiggly import
- Choose "Add to classpath" or the option to add JUnit
- VS Code will offer to download JUnit automatically — accept

## Still Stuck?

Post in #lab on Discord with:
- Operating system (Mac or Windows)
- Screenshot of the error
- Which step is failing

Do not wait until exam start to flag issues.