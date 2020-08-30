java -cp astor.jar fr.inria.main.evolution.AstorMain \
-location /home/cuong/IdeaProjects/apr-repo/regression-bugs \
-dependencies /home/cuong/IdeaProjects/apr-repo/regression-bugs/target/dependency \
-faultfile /home/cuong/IdeaProjects/jrelifix/SusFiles/PerfectFL/Bears-220.txt \
-mode jgenprog \
-srcjavafolder /src/main/java \
-srctestfolder /src/test/java \
-binjavafolder /target/classes \
-bintestfolder /target/test-classes \
-stopfirst true