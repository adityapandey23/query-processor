# LogX - Query Processor for Logging System

A SQL-like query processor that provides a powerful and intuitive interface for searching and retrieving logs from multiple storage backends.

## What is it?

LogX Query Processor is a custom-built log querying system that allows you to search through logs using a SQL-like query language. Built with ANTLR4, it parses custom query syntax and processes log searches across different data stores. The system provides two main query types:

- **SELECT queries**: Retrieve logs within a specific time range
- **FIND queries**: Search for specific patterns or keywords in logs

The processor reads serialized Java log objects containing metadata such as:
- Log data/message
- Timestamp (Unix epoch)
- Thread ID and Thread Name
- Severity level (CRITICAL, HIGH, MEDIUM, LOW, WARN, UNDEFINED)
- Stack trace information

## Why are we using it?

Traditional log searching can be cumbersome and require:
- Direct file system access and parsing
- Complex Elasticsearch queries
- Writing custom code for each search scenario
- Understanding underlying storage mechanisms

LogX Query Processor solves these problems by:

1. **Abstraction**: Provides a unified query interface regardless of underlying storage (file system or Elasticsearch)
2. **Simplicity**: SQL-like syntax that's familiar and easy to learn
3. **Flexibility**: Support for multiple storage backends with easy extensibility
4. **Efficiency**: Built-in binary search for time-range queries using timestamps
5. **Type Safety**: Strongly-typed AST (Abstract Syntax Tree) representation of queries
6. **Interactive CLI**: User-friendly command-line interface with help system

## How are we using it?

### Installation & Build

```bash
# Clone the repository
cd query-processor

# Build the project
mvn clean compile

# Run the application
mvn exec:java
```

### Query Syntax

The query processor supports two types of queries:

#### 1. **SELECT Query** (Time-range based search)

```sql
SELECT field1, field2, field3 FROM XXXXXXXXXX.log BETWEEN YYYYYYYYYY AND ZZZZZZZZZZ;
```

**Example:**
```sql
SELECT error, exception, failed FROM 1234567890.log BETWEEN 1234567890 AND 1234569999;
```

- `field1, field2, ...`: Keywords/patterns to search for in log messages
- `XXXXXXXXXX`: 10-digit timestamp identifier for the log file
- `YYYYYYYYYY`: Start timestamp (Unix epoch, 10 digits)
- `ZZZZZZZZZZ`: End timestamp (Unix epoch, 10 digits)

#### 2. **FIND Query** (Search across entire log file)

```sql
FIND field1, field2, field3 IN XXXXXXXXXX.log;
```

**Example:**
```sql
FIND error, warning, critical IN 1234567890.log;
```

- `field1, field2, ...`: Keywords/patterns to search for
- `XXXXXXXXXX`: 10-digit timestamp identifier for the log file

### Interactive Usage

When you run the application:

```bash
mvn exec:java
```

You'll be prompted to:

1. **Select data source** (elasticsearch or file)
   - For Elasticsearch: Provide host URL and API key
   - For File: Uses default `~/logs` directory

2. **Enter queries** at the interactive prompt
   - Type `?` for help
   - Type `exit` to quit

**Example Session:**
```
Enter source type (elasticsearch/file): 
file
(Press ? for help)
Enter your query: FIND NullPointerException IN 1696118400.log;
-------------------------ELEMENT: NullPointerException-------------------------
Thread-1
Worker-Thread
java.lang.NullPointerException at line 42
2023-10-01 00:00:00.0
... stack trace ...
```

## Technologies Used

### Core Technologies
- **Java 17**: Primary programming language with modern features (records, switch expressions)
- **Apache Maven**: Build automation and dependency management
- **ANTLR4 (v4.13.2)**: Parser generator for creating the custom query language
  - Grammar definition in `Query.g4`
  - Generates lexer, parser, and visitor classes
  - Visitor pattern for AST construction

### Dependencies
- **Elasticsearch Java Client (v9.0.1)**: For Elasticsearch integration
- **SLF4J NOP (v2.0.9)**: Logging facade (silent mode for Elasticsearch logs)
- **JUnit Jupiter (v5.11.0)**: Unit testing framework

### Design Patterns
- **Factory Pattern**: `ReaderFactory` and `QueryProcessorFactory` for creating appropriate instances
- **Strategy Pattern**: Different readers (File, Elasticsearch) implementing common `Reader` interface
- **Visitor Pattern**: ANTLR-generated visitors for AST traversal
- **Record Classes**: Immutable data carriers for AST nodes (`SelectBetween`, `FindIn`)

## Supported Stores

### 1. **File System Storage**

**Configuration:**
- Default location: `~/logs/` (auto-created if not exists)
- File format: Serialized Java objects (`.log` files)
- File naming: `{10-digit-timestamp}.log`

**How it works:**
- Reads serialized `Log` objects using Java's `ObjectInputStream`
- Stores logs as binary files for fast deserialization
- Suitable for local development and small-scale deployments

**Example:**
```bash
# File location
/home/user/logs/1696118400.log
```

### 2. **Elasticsearch**

**Configuration:**
- Host URL: Elasticsearch server endpoint
- API Key: Authentication token

**How it works:**
- Connects to Elasticsearch cluster using Java client
- Index name derived from filename (timestamp portion)
- Performs `match_all` query with size limit of 1000 documents
- Maps Elasticsearch documents to `Log` POJO

**Example:**
```bash
Enter source type (elasticsearch/file): 
elasticsearch
Enter the host URL: 
https://localhost:9200
Enter the API key: 
your-api-key-here
```

### Extensibility

Adding a new storage backend is straightforward:

1. Implement the `Reader` interface
2. Add logic to `ReaderFactory` to instantiate your reader
3. Your reader should return `List<Log>` from the `read(String logFile)` method

## Project Structure

```
query-processor/
├── src/main/java/tech/thedumbdev/
│   ├── antlr4/           # ANTLR grammar definition
│   │   └── Query.g4
│   ├── ast/              # Abstract Syntax Tree nodes
│   │   ├── ASTQuery.java
│   │   ├── FindIn.java
│   │   └── SelectBetween.java
│   ├── enums/            # Enumerations
│   │   └── Severity.java
│   ├── gen/              # ANTLR generated classes
│   ├── parser/           # AST builder
│   │   └── ASTBuilder.java
│   ├── pojo/             # Plain Old Java Objects
│   │   └── Log.java
│   ├── queryprocessor/   # Query execution logic
│   │   ├── FindQueryProcessor.java
│   │   ├── SelectQueryProcessor.java
│   │   ├── QueryProcessor.java
│   │   └── QueryProcessorFactory.java
│   ├── reader/           # Data source readers
│   │   ├── Reader.java
│   │   ├── FileReader.java
│   │   ├── ElasticReader.java
│   │   └── ReaderFactory.java
│   ├── util/             # Utility classes
│   │   └── Occurrence.java (Binary search for timestamps)
│   └── App.java          # Main entry point
└── pom.xml               # Maven configuration
```

## Features

- ✅ **Custom Query Language**: SQL-like syntax for log searching
- ✅ **Multi-backend Support**: File system and Elasticsearch
- ✅ **Time-range Queries**: Efficient binary search on timestamps
- ✅ **Multi-field Search**: Search for multiple keywords simultaneously
- ✅ **Interactive CLI**: User-friendly command-line interface
- ✅ **Detailed Log Output**: Thread info, timestamps, stack traces
- ✅ **Error Handling**: Comprehensive error messages and validation
- ✅ **Type Safety**: Compile-time type checking with records and enums

This project is part of a logging-notification-system.

---

**Author**: thedumbdev  
**Version**: 1.0-SNAPSHOT
