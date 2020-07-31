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

## Usage
### Rename all arxiv-files in directory:
`java -jar <filename.jar> all`  
This renames all files that currently have names like `2007.13845.pdf`.

### Rename specific arxiv-files in directory:
`java -jar <filename.jar> file1 file2 ...`  
The files have to have their original arxiv-names.



## Roadmap
[ ] Improve support for files in different directories  
[ ] Add metadata to the files, instead of just renaming them  
[ ] Extract information from the pdfs instead of connecting to arxiv.org
