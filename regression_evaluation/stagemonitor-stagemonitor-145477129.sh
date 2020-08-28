java -cp astor.jar fr.inria.main.evolution.AstorMain \
-location /home/cuong/IdeaProjects/apr-repo/regression-bugs/stagemonitor-core \
-dependencies /home/cuong/IdeaProjects/apr-repo/regression-bugs/stagemonitor-core/build/libs/lib \
-faultfile /home/cuong/IdeaProjects/jrelifix/SusFiles/PerfectFL/stagemonitor-stagemonitor-145477129.txt \
-mode jgenprog \
-srcjavafolder /src/main/java \
-srctestfolder /src/test/java \
-binjavafolder /build/classes/main \
-bintestfolder /build/classes/test \
-stopfirst true
