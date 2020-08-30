java -cp astor.jar fr.inria.main.evolution.AstorMain \
-location /Users/cuong/IdeaProjects/jrelifix/BugsDataset \
-dependencies /Users/cuong/IdeaProjects/jrelifix/BugsDataset/target/dependency \
-faultfile /Users/cuong/IdeaProjects/jrelifix/SusFiles/PerfectFL/mybatis-mybatis-3-117115623.txt \
-mode jgenprog \
-srcjavafolder /src/main/java \
-srctestfolder /src/test/java \
-binjavafolder /target/classes \
-bintestfolder /target/test-classes \
-stopfirst true