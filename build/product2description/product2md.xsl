<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="text" version="1.0" encoding="UTF-8" omit-xml-declaration="yes"
	indent="no" />
	<xsl:param name="path"
		select="'/home/urszeidler/git/snca-editor/'" />
	<xsl:template match="/"><xsl:apply-templates /></xsl:template>
	<xsl:template match="aboutInfo|launcherArgs|license|vm"></xsl:template>
	<xsl:template match="product"><xsl:value-of select="@name"/> [<xsl:value-of select="@version"/>]

id: <xsl:value-of select="@id"/> uid: <xsl:value-of select="@uid"/> application: <xsl:value-of select="@application"/>

<xsl:apply-templates />
</xsl:template>
	<xsl:template match="feature">
<xsl:variable name="featurePath" select="concat($path,  @id)" />
<xsl:variable name="plugins"
		select="document(concat($featurePath,'/feature.xml'),/)" />
* <xsl:value-of select="@id"/> [<xsl:value-of select="@version"/>]<xsl:for-each select="$plugins"><xsl:for-each select="feature/plugin">
    * <xsl:value-of select="@id"/> [<xsl:value-of select="@version"/>] <xsl:if test="@fragment='true'">[F]</xsl:if></xsl:for-each></xsl:for-each>
</xsl:template>
	<xsl:template
		match="text()[not(string-length(normalize-space()))]" />
	<xsl:template
		match="text()[string-length(normalize-space()) > 0]">
		<xsl:value-of select="translate(.,'&#xA;&#xD;', '  ')" />
	</xsl:template>
</xsl:stylesheet>