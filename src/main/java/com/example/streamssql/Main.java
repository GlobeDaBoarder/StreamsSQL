package com.example.streamssql;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    static class XmlUtils {

        public static Map<String, Long> countAllByTagName(List<XmlFile> files, String tagName) {
            return null;
        }
    }

    static class Tag {
        private final String name;

        public Tag(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    static class XmlFile {
        private final String id;
        private final String encoding;
        private final List<Tag> tags;

        public XmlFile(String id, String encoding, List<Tag> tags) {
            this.id = id;
            this.encoding = encoding;
            this.tags = tags;
        }

        public String getId() {
            return id;
        }

        public List<Tag> getTags() {
            return tags;
        }

        public String getEncoding() {
            return encoding;
        }
    }
    public static void main(String[] args) {
        List<XmlFile> xmlFiles = List.of(
                new XmlFile("1", "UTF-8", List.of(new Tag("function"), new Tag("load"))),
                new XmlFile("2", "UTF-8", List.of(new Tag("table"), new Tag("main"))),
                new XmlFile("3", "ASCII", List.of(new Tag("row"), new Tag("column"))),
                new XmlFile("4", "ASCII", List.of(new Tag("sheet"), new Tag("row"))),
                new XmlFile("5", "ASCII", List.of(new Tag("sheet"), new Tag("column"), new Tag("row")))
        );

        // Pavel's task:
        // If XmlFile in it's list of tags has a "sheet" tagName count all tags of that XmlFile. If no tagName fo sheet, don't count it. Group by encoding .
        //  So the result should be: {"UTF-8"=0, "ASCII"=5}, 5 because XmlFIle with ID 4 has 2 Tags, and one of them is sheet, so we count both. XmlFIle with ID 5 has 3 Tags, and one of them is sheet, so we count alll three of them. 3 + 2 = 5


        Map<String, Long> encodingsToTagCounts = xmlFiles.stream()
        .collect(Collectors.groupingBy(
                        XmlFile::getEncoding,
                        Collectors.filtering(
                                xmlFile -> xmlFile.getTags().stream().map(Tag::getName).anyMatch(tagName -> tagName.equals("sheet")),
                                Collectors.summingLong(xmlFile -> xmlFile.getTags().size())
                        )
                ));


        System.out.println(encodingsToTagCounts);


        // Unique list of tags for each encoding type. Result should be: {UTF-8=[load, function, main, table], ASCII=[column, sheet, row]}
         Map<String, Set<String>> encodingTypeToUniqueTags = xmlFiles.stream()
                 .collect(Collectors.groupingBy(
                         XmlFile::getEncoding,
                         Collectors.flatMapping(xmlFile -> xmlFile.getTags().stream().map(Tag::getName), Collectors.toSet())
                 ));

        System.out.println(encodingTypeToUniqueTags);

    }
}
