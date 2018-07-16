<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" version="1.0" encoding="UTF-8" omit-xml-declaration="yes"
	indent="yes"  />
	<xsl:param name="path"
		select="'/home/urszeidler/git/snca-editor/'" />
	<xsl:template match="/">
	<xsl:apply-templates /></xsl:template>
	<xsl:template match="aboutInfo|launcherArgs|license|vm"></xsl:template>
	<xsl:template match="product">
<html>
	<head>
	</head>
	<body>
	<h2><xsl:value-of select="@name"/> [<xsl:value-of select="@version"/>]</h2>

<p>id: <xsl:value-of select="@id"/></p>
<p> uid: <xsl:value-of select="@uid"/></p>
<p> application: <xsl:value-of select="@application"/></p>
<p> splash: <xsl:value-of select="splash/@location"/> </p><img  >
<xsl:attribute name="src"><xsl:value-of select="concat($path,splash/@location,'/splash.bmp')"/></xsl:attribute>
</img> 

<p>
about: 
<img  >
<xsl:attribute name="src"><xsl:value-of select="concat($path,splash/@location,'/',aboutInfo/image/@path)"/></xsl:attribute>
</img> 
<xsl:value-of select="aboutInfo/text/text()"/>
</p>
<br/>
<h4>features and plugins</h4>
<ul>
<xsl:apply-templates />
</ul>
	</body>
</html>
</xsl:template>
	<xsl:template match="feature">
<xsl:variable name="featurePath" select="concat($path,  @id)" />
<xsl:variable name="plugins"
		select="document(concat($featurePath,'/feature.xml'),/)" />
<li> <xsl:value-of select="@id"/> [<xsl:value-of select="@version"/>]</li>
<ul>
<xsl:for-each select="$plugins">
<xsl:for-each select="feature/plugin">
<li><xsl:value-of select="@id"/> [<xsl:value-of select="@version"/>] <xsl:if test="@fragment='true'">[F]</xsl:if></li>
</xsl:for-each>
</xsl:for-each>
</ul>
</xsl:template>
	<xsl:template
		match="text()[not(string-length(normalize-space()))]" />
	<xsl:template
		match="text()[string-length(normalize-space()) > 0]">
		<xsl:value-of select="translate(.,'&#xA;&#xD;', '  ')" />
	</xsl:template>
</xsl:stylesheet>