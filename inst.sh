#!/bin/bash

# =============================================
# Installationsscript til Java + React projekt
# Kør i WSL2 / Ubuntu 24.04
# =============================================

set -e  # Stop ved første fejl

echo "Opdaterer pakke-liste..."
sudo apt update -y

echo "Installerer Java 21 (JDK)..."
sudo apt install openjdk-21-jdk -y

echo "Installerer Node.js 20 + npm..."
curl -fsSL https://deb.nodesource.com/setup_20.x | sudo -E bash -
sudo apt install -y nodejs

echo "Installerer Maven..."
sudo apt install maven -y

echo "Renser op..."
sudo apt autoremove -y

echo ""
echo "Installation færdig! Tjek versioner:"
echo "----------------------------------------"
java --version
node --version
mvn --version
echo "----------------------------------------"
echo "Du er klar til at køre projektet!"