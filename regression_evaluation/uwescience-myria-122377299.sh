java -cp astor.jar fr.inria.main.evolution.AstorMain \
-location /home/cuong/IdeaProjects/apr-repo/regression-bugs \
-dependencies /home/cuong/IdeaProjects/apr-repo/regression-bugs/target/dependency \
-faultfile /home/cuong/IdeaProjects/jrelifix/SusFiles/PerfectFL/uwescience-myria-122377299.txt \
-mode jgenprog \
-srcjavafolder /src \
-srctestfolder /test \
-binjavafolder /build/main \
-bintestfolder /build/test \
-stopfirst true