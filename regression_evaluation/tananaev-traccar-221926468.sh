java -cp astor.jar fr.inria.main.evolution.AstorMain \
-location /home/cuong/IdeaProjects/apr-repo/regression-bugs \
-dependencies /home/cuong/IdeaProjects/apr-repo/regression-bugs/target/dependency \
-faultfile /home/cuong/IdeaProjects/jrelifix/SusFiles/PerfectFL/tananaev-traccar-221926468.txt \
-mode jmutrepair \
-srcjavafolder /src \
-srctestfolder /test \
-binjavafolder /target/classes \
-bintestfolder /target/test-classes \
-stopfirst true
