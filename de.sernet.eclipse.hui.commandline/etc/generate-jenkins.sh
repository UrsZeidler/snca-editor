#!bin/bash

instance=$WORKSPACE/de.sernet.eclipse.hui.product/target/products/de.sernet.eclipse.hui.product/linux/gtk/x86_64/snca-editor/snca-editor
snca_file=$WORKSPACE/build/rcptt/test-data/SNCA.xml
data=$WORKSPACE/build/wks

mkdir -p $WORKSPACE/build/wks

echo "starting $instance with $snca_file"
echo "using workspace: $data"

$instance  -nosplash -consolelog -data $data \
 -application de.sernet.eclipse.hui.commandline.commandlinerunner \
 -i $snca_file -generateJava -generateMarkdown -export