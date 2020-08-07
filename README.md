# ArxivRenamer
Program for giving arxiv pdfs better names
 
## Introduction
While arxiv is a great resource,
it has one shortcoming: the default filenames are just numeric strings.  
This project aims to fix that,
by allowing the user to easily batch rename articles from the command line.

## Requirements
* Java
* An internet connection

## Installation
Download the jar file, move it where ever it suits you.  
If placed in the home directory, add the following line to your `.bashrc`:  
`alias arxiv-rename="java -jar ~/ArxivRenamer.jar"`

## Usage
### Rename all arxiv-files in directory:
`java -jar <filename.jar> all`  
This renames all files that currently have names like `2007.13845.pdf`.

### Rename specific arxiv-files in directory:
`java -jar <filename.jar> file1 file2 ...`  
The files have to have their original arxiv-names.

## Building locally
To be continued...

## Roadmap
* [ ] Improve support for files in different directories  
* [ ] Add metadata to the files, instead of just renaming them  
* [ ] Extract information from the pdfs instead of connecting to arxiv.org
* [ ] Add more formatting options
* [ ] Add more options for which characters to remove
* [ ] Add date to name
* [ ] Add options to rename or copy