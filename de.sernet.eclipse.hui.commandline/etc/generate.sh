#!bin/bash

instance=/home/urszeidler/git/snca-editor/de.sernet.eclipse.hui.product/target/products/de.sernet.eclipse.hui.product/linux/gtk/x86_64/snca-editor/snca-editor
snca_file=/home/urszeidler/git-e4/verinice/sernet.gs.server/WebContent/WEB-INF/SNCA.xml
data=/home/urszeidler/etc/tmp/tt-1

$instance  -nosplash -consolelog -data $data \
 -application de.sernet.eclipse.hui.commandline.commandlinerunner \
 -i $snca_file -generateJava -generateMarkdown -export