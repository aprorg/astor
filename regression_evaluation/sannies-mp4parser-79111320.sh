java -cp astor.jar fr.inria.main.evolution.AstorMain \
-location /home/cuong/IdeaProjects/apr-repo/regression-bugs/streaming \
-dependencies /home/cuong/IdeaProjects/apr-repo/regression-bugs/target/dependency \
-faultfile /home/cuong/IdeaProjects/jrelifix/SusFiles/PerfectFL/sannies-mp4parser-79111320.txt \
-mode jmutrepair \
-srcjavafolder /src \
-srctestfolder /test \
-binjavafolder /target/classes \
-bintestfolder /target/test-classes \
-stopfirst true
