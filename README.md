# SNCA Editor

The snca editor is an emf based editor to edit, verify and document the snca description of the ISMS verinice. see https://github.com/SerNet/verinice

## basic usage

The snca editor can be startet as a gui program to edit the snca.xml together with the language files, and also used as a commandline tool.


### as editor

Start the program snca-editor. Import a snca.xml file. Start editing the file or generating documentation. Export the snca file back to the raw xml.

### as commandline tool

To use the snca-editor as part of your tool chain, you can access various functions as commandline tool.

basic command -i <the snca.xml> [action switches -generateMarkdown -generateWiki -export -validate <INFO|WARNING|ERROR> ]

* generateMarkdown - generates a markdown file together with dot files for each entity, the dot file need post processing by the dot program
* generateWiki - same as markdown but in wiki syntax, use markdown and pandoc for transforming
* validate - validate the snca against the defined rules and print the findings to sysout

## build

The SCNA Editor is build with tycho and maven


> git clone xxxx  
> cd snca-editor  
> mvn clean verify  

which build the product for win, mac and linux 
and can be found at  __/de.sernet.eclipse.hui.product/target/products__


### development

To setup and checkout the code, use the eclipse installer and the [snca-editor-workspace.setup](https://raw.githubusercontent.com/UrsZeidler/snca-editor/master/de.sernet.eclipse.hui.parent/build/etc/ide/snca-editor-workspace.setup) Oohmp setup, which will install and configure a eclipse installation, and checkout the code and import it.

* download the [installer](https://wiki.eclipse.org/Eclipse_Installer), get the setup file and install.  
Switch to advanced mode. On the first page (product selection), choose whatever product your eclipse should be based upon. On the second page, you can drag your SimYardSale.setup file from the system explorer onto the “eclipse.org” top node. Double click it, so that it is shown in the three lists below.


