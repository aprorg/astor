java -cp astor.jar fr.inria.main.evolution.AstorMain \
-location /home/cuong/IdeaProjects/apr-repo/regression-bugs/guice/hibernate \
-dependencies /home/cuong/IdeaProjects/apr-repo/regression-bugs/guice/hibernate/target/dependency \
-faultfile /home/cuong/IdeaProjects/jrelifix/SusFiles/PerfectFL/petergeneric-stdlib-292030904.txt \
-mode jgenprog \
-srcjavafolder /src/main/java \
-srctestfolder /src/test/java \
-binjavafolder /target/classes \
-bintestfolder /target/test-classes \
-stopfirst true