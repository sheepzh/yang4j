# Yang4J

## Profile
The Yang4J is a compiler and validator of YANG module language for Java.

+ Compile the schemas string or file to a memory model, which is an instance implementing the interface named <b>Statement.class</b> in Yang4J.
+ Generate Java files.
+ Generate XML files.
+ Generate YIN.

# Get Start

```java
String schemas = "" +
 　　"module {" +
 　　"　　/* The substatements of module are omitted */" +
 　　"}";

// 1st, generate the memory module from schemas.
Yang yang = new Yang().setSchemas(schemas).build();

// 2nd, obtain the module.
Module module = yang.getRoot();

// 3st, generate Java files.
String javaFileDirPath = "d:\\yang\\src\\com\\yang\\module";
try {
    yang.generateJava(javaFileDirPath);
} catch(IOException ioe){
}

// 4th, generate XML file.
String xmlFilePath = "d:\\yang_test.xml";
try {
    yang.generateXml(xmlFilePath);
} catch(IOException ioe){
}
```