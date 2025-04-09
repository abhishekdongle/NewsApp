# Start end-to-end project creation and deployment.

## Create a project in Android Studio with the appropriate project name and package name.
## Push the code to Git by using the following commands in the terminal:
Note: Make sure to uncheck the "Initialize this repository with a README" option when creating the repository on GitHub, 
since we're initializing the project from Android Studio.

git init                             # Initialize git locally
git add .                            # Add all project files
git commit -m "Initial commit"       # First commit
git branch -M main                   # Rename branch to main (optional, recommended)
git remote add origin https://github.com/your-username/your-repo.git
git push -u origin main              # Push to GitHub

## Setup username and password for git access:
git config --global user.email "you@example.com"
git config --global user.name "Your Name"

## Create README file:
touch README.md
Note: Write the description required to build the project

## Add README file:
git add README.md
git commit -m "Add README"
git push
