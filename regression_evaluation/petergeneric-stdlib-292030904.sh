java -cp astor.jar fr.inria.main.evolution.AstorMain \
-location /Users/cuong/IdeaProjects/jrelifix/BugsDataset/guice/hibernate \
-dependencies /Users/cuong/IdeaProjects/jrelifix/BugsDataset/guice/hibernate/target/dependency \
-faultfile /Users/cuong/IdeaProjects/jrelifix/SusFiles/PerfectFL/petergeneric-stdlib-292030904.txt \
-mode jgenprog \
-srcjavafolder /src/main/java \
-srctestfolder /src/test/java \
-binjavafolder /target/classes \
-bintestfolder /target/test-classes \
-stopfirst true