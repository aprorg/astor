java -cp astor.jar fr.inria.main.evolution.AstorMain \
-location /home/cuong/IdeaProjects/apr-repo/regression-bugs/capsule \
-dependencies /home/cuong/IdeaProjects/apr-repo/regression-bugs/build/dependency-libs \
-faultfile /home/cuong/IdeaProjects/jrelifix/SusFiles/PerfectFL/puniverse-capsule-78565048.txt \
-mode jgenprog \
-srcjavafolder /src/main/java \
-srctestfolder /src/test/java \
-binjavafolder /build/classes/java/main \
-bintestfolder /build/classes/java/test \
-stopfirst true
