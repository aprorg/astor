java -cp astor.jar fr.inria.main.evolution.AstorMain \
-location /home/cuong/IdeaProjects/apr-repo/regression-bugs/modules/swagger-codegen \
-dependencies /home/cuong/IdeaProjects/apr-repo/regression-bugs/modules/swagger-codegen/target/dependency \
-faultfile /home/cuong/IdeaProjects/jrelifix/SusFiles/PerfectFL/Bears-186.txt \
-mode jgenprog \
-srcjavafolder /src/main/java \
-srctestfolder /src/test/java \
-binjavafolder /target/classes \
-bintestfolder /target/test-classes \
-stopfirst true