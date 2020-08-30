java -cp astor.jar fr.inria.main.evolution.AstorMain \
-location /Users/cuong/IdeaProjects/jrelifix/BugsDataset/byte-buddy-dep \
-dependencies /Users/cuong/IdeaProjects/jrelifix/BugsDataset/byte-buddy-dep/target/dependency \
-faultfile /home/cuong/IdeaProjects/jrelifix/SusFiles/PerfectFL/raphw-byte-buddy-171322757.txt \
-mode jmutrepair \
-srcjavafolder /src/main/java \
-srctestfolder /src/test/java \
-binjavafolder /target/classes \
-bintestfolder /target/test-classes \
-stopfirst true