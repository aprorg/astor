java -cp astor.jar fr.inria.main.evolution.AstorMain \
-location /Users/cuong/IdeaProjects/jrelifix/BugsDataset/tools \
-dependencies /Users/cuong/IdeaProjects/jrelifix/BugsDataset/tools/target/dependency:/Users/cuong/IdeaProjects/jrelifix/BugsDataset/contract/target/dependency:/Users/cuong/IdeaProjects/jrelifix/BugsDataset/contract/target/classes \
-faultfile /Users/cuong/IdeaProjects/jrelifix/SusFiles/PerfectFL/owlcs-owlapi-93793148.txt \
-mode jgenprog \
-srcjavafolder /src/main/java \
-srctestfolder /../contract/src/test/java \
-binjavafolder /target/classes \
-bintestfolder /../contract/target/test-classes \
-stopfirst true
