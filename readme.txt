To run the provided Java program in Visual Studio Code (VSCode), you need to follow these steps:

1. **Install Java Development Kit (JDK)**:
   Ensure that you have JDK installed on your system. You can download and install JDK from the official Oracle website or use OpenJDK.

2. **Install Visual Studio Code**:
   If you haven't already installed VSCode, download and install it from the official website.

3. **Install Java Extension Pack** (Optional):
   Install the Java Extension Pack for VSCode, which includes essential extensions for Java development, such as language support, debugging, and project management.

4. **Create Java Project** (Optional):
   If you want to manage your Java project within VSCode, create a new Java project using VSCode's built-in functionality or using external tools like Maven or Gradle.

5. **Open Workspace**:
   Open the workspace containing your Java files or create a new workspace.

6. **Create Java File**:
   Create a new Java file (e.g., `AdServer.java`) and paste the provided code into this file.

7. **Create Input Files**:
   Create input files `sites.csv` and `ads.csv` as per the provided format. You can place these files in the same directory as your Java file or specify their paths accordingly.

8. **Adjust File Paths (Optional)**:
   If your input files are located in a different directory, make sure to adjust the file paths in the `main()` method where the `AdServer` object is initialized.

9. **Run the Program**:
   Open the terminal in VSCode, navigate to the directory containing your Java file, and compile the Java file using the `javac` command:
   ```
   javac AdServer.java
   ```
   Then, run the compiled Java program using the `java` command and provide the input file paths as arguments:
   ```
   java AdServer sites.csv ads.csv
   ```

10. **Provide Input**:
    Once the program is running, you can provide input (site IDs) through the terminal. Enter site IDs one by one, and the program will output the corresponding ad ID and price.

11. **Exit the Program**:
    To exit the program, input `-1`.

