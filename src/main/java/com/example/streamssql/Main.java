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



        // Unique list of tags for each encoding type. Result should be: {UTF-8=[load, function, main, table], ASCII=[column, sheet, row]}
         Map<String, Set<String>> encodingTypeToUniqueTags = xmlFiles.stream()
                         . ...

        System.out.println(encodingTypeToUniqueTags);

    }
}
