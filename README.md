# Yang4J

### Overview & Features
The Yang4J is a validator and compiler of YANG module language for Java.

+ Validate and compile the schemas string to a memory model, which is an instance implementing the interface named <b>Statement.class</b> in Yang4J.

### Get Start
```java
String schemas = "" +
 　　"module {" +
 　　"　　/* The substatements of module are omitted */" +
 　　"}";

// Validate and generate the memory module from schemas.
Yang yang = new Yang(schemas);
```
### Future

+ YANG to YIN, YIN to YANG
+ Generate a structure XML of memory model
+ Interface of translator framework for other languages, such as JSON, Java etc.

### Compatibility

Yang4J is compatible with all the following RFCs:

+ RFC 6020 YANG - A Data Modeling Language for the Network Configuration Protocol