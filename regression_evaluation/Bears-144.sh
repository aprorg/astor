java -Xmx6g -cp astor.jar fr.inria.main.evolution.AstorMain \
-location /Users/cuong/IdeaProjects/jrelifix/BugsDataset/core \
-dependencies /Users/cuong/IdeaProjects/jrelifix/BugsDataset/core/target/dependency:/Users/cuong/IdeaProjects/jrelifix/BugsDataset/suite/spdz/target/dependency:/Users/cuong/IdeaProjects/jrelifix/BugsDataset/suite/spdz/target/classes \
-faultfile /Users/cuong/IdeaProjects/jrelifix/SusFiles/PerfectFL/Bears-144.txt \
-mode jgenprog \
-srcjavafolder /src/main/java \
-srctestfolder /../suite/spdz/src/test/java \
-binjavafolder /target/classes \
-bintestfolder /../suite/spdz/target/test-classes \
-stopfirst true
