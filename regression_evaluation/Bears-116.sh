java -cp astor.jar fr.inria.main.evolution.AstorMain \
-location /home/cuong/IdeaProjects/apr-repo/regression-bugs \
-dependencies /home/cuong/IdeaProjects/apr-repo/regression-bugs/target/dependency \
-faultfile /home/cuong/IdeaProjects/jrelifix/SusFiles/PerfectFL/Bears-116.txt \
-mode jgenprog \
-srcjavafolder /src \
-srctestfolder /test \
-binjavafolder /target/classes \
-bintestfolder /target/test-classes \
-stopfirst true