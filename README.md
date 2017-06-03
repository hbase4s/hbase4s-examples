# Examples of using HBase4s


## Instructions

Clone repository and build with `sbt`.

Requirements:
- Java 8+
- Sbt 0.13+



### Running examples locally

1. Download and install HBase from hbase.apache.org (version 1.3.1 or newer).
2. Start HBase server: `start-hbase.sh`
3. Open shell `hbase shell` and create transactions table with event column family: 
 ``create 'transactions','event'``
4. Run ``HelloHBase`` class with simple example of *hbase4s* usage