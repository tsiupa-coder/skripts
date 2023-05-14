#!/bin/bash

# Create a directory to store the script
mkdir -p ~/.custom-commands

## Create the script file
cp ./Time.groovy ~/.custom-commands/alarm

# Make the script executable
chmod +x ~/.custom-commands/alarm

# Add the custom commands directory to the PATH
# shellcheck disable=SC2129
echo '' >> ~/.bashrc
echo '# Add custom commands directory to PATH' >> ~/.bashrc
# shellcheck disable=SC2016
echo 'export PATH="$HOME/.custom-commands:$PATH"' >> ~/.bashrc

# Refresh the current terminal session
# shellcheck disable=SC1090
source ~/.bashrc

echo "Installation completed. You can now use the 'alarm' command."
