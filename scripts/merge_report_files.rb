#!/usr/bin/env ruby

# Usage:
#
#   ./merge_report_files <xml-dir> <tag> <output_file>
#
# For example:
#
#   ./merge_report_files ./app/build/reports/ktlint file ./build/reports/ktlint-reports.xml
#

require 'rexml/document'

include REXML

inputDir = ARGV[0]
tag = ARGV[1]
outputFile = ARGV[2]

root = nil

report_files = Dir["#{inputDir}/**/*.xml"]
for file in report_files do
  xmlfile = File.open(file)
  xmldoc = Document.new(xmlfile)
  if root.nil?
    root = xmldoc.root
  end

  xmldoc.root.elements.each("#{tag}") do | el |
    root.elements.add(el)
  end
end

ktlintFile = File.open(outputFile, "w")
ktlintFile.puts '<?xml version="1.0" encoding="utf-8"?>'
ktlintFile.puts root
