java -cp astor.jar fr.inria.main.evolution.AstorMain \
-location /home/cuong/IdeaProjects/apr-repo/regression-bugs/byte-buddy-dep \
-dependencies /home/cuong/IdeaProjects/apr-repo/regression-bugs/byte-buddy-dep/target/dependency \
-faultfile /home/cuong/IdeaProjects/jrelifix/SusFiles/PerfectFL/raphw-byte-buddy-107351165.txt \
-mode jgenprog \
-srcjavafolder /src/main/java \
-srctestfolder /src/test/java \
-binjavafolder /target/classes \
-bintestfolder /target/test-classes \
-stopfirst true