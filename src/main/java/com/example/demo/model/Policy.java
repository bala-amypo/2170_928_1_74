coder@4bc7b6c0c98f:~/Workspace/demo$ mvn clean install
[INFO] Scanning for projects...
[INFO] 
[INFO] --------------------------< com.example:demo >--------------------------
[INFO] Building demo 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:3.3.2:clean (default-clean) @ demo ---
[INFO] Deleting /home/coder/Workspace/demo/target
[INFO] 
[INFO] --- maven-resources-plugin:3.3.1:resources (default-resources) @ demo ---
[INFO] Copying 1 resource from src/main/resources to target/classes
[INFO] Copying 0 resource from src/main/resources to target/classes
[INFO] 
[INFO] --- maven-compiler-plugin:3.11.0:compile (default-compile) @ demo ---
[INFO] Changes detected - recompiling the module! :source
[INFO] Compiling 42 source files with javac [debug release 17] to target/classes
[INFO] -------------------------------------------------------------
[ERROR] COMPILATION ERROR : 
[INFO] -------------------------------------------------------------
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/model/Policy.java:[1,8] class, interface, enum, or record expected
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/model/Policy.java:[3,8] class, interface, enum, or record expected
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/model/Policy.java:[5,5] class, interface, enum, or record expected
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/model/Policy.java:[6,5] class, interface, enum, or record expected
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/model/Policy.java:[7,5] class, interface, enum, or record expected
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/model/Policy.java:[8,5] class, interface, enum, or record expected
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/model/Policy.java:[9,1] class, interface, enum, or record expected
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/model/Claim.java:[1,8] class, interface, enum, or record expected
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/model/Claim.java:[3,8] class, interface, enum, or record expected
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/model/Claim.java:[5,5] class, interface, enum, or record expected
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/model/Claim.java:[6,5] class, interface, enum, or record expected
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/model/Claim.java:[7,5] class, interface, enum, or record expected
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/model/Claim.java:[8,1] class, interface, enum, or record expected
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/model/FraudRule.java:[1,8] class, interface, enum, or record expected
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/model/FraudRule.java:[4,8] class, interface, enum, or record expected
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/model/FraudRule.java:[6,5] class, interface, enum, or record expected
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/model/FraudRule.java:[7,5] class, interface, enum, or record expected
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/model/FraudRule.java:[8,5] class, interface, enum, or record expected
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/model/FraudRule.java:[9,5] class, interface, enum, or record expected
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/model/FraudRule.java:[10,1] class, interface, enum, or record expected
[INFO] 20 errors 
[INFO] -------------------------------------------------------------
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  20.993 s
[INFO] Finished at: 2025-12-26T06:51:38Z
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.11.0:compile (default-compile) on project demo: Compilation failure: Compilation failure: 
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/model/Policy.java:[1,8] class, interface, enum, or record expected
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/model/Policy.java:[3,8] class, interface, enum, or record expected
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/model/Policy.java:[5,5] class, interface, enum, or record expected
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/model/Policy.java:[6,5] class, interface, enum, or record expected
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/model/Policy.java:[7,5] class, interface, enum, or record expected
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/model/Policy.java:[8,5] class, interface, enum, or record expected
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/model/Policy.java:[9,1] class, interface, enum, or record expected
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/model/Claim.java:[1,8] class, interface, enum, or record expected
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/model/Claim.java:[3,8] class, interface, enum, or record expected
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/model/Claim.java:[5,5] class, interface, enum, or record expected
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/model/Claim.java:[6,5] class, interface, enum, or record expected
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/model/Claim.java:[7,5] class, interface, enum, or record expected
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/model/Claim.java:[8,1] class, interface, enum, or record expected
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/model/FraudRule.java:[1,8] class, interface, enum, or record expected
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/model/FraudRule.java:[4,8] class, interface, enum, or record expected
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/model/FraudRule.java:[6,5] class, interface, enum, or record expected
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/model/FraudRule.java:[7,5] class, interface, enum, or record expected
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/model/FraudRule.java:[8,5] class, interface, enum, or record expected
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/model/FraudRule.java:[9,5] class, interface, enum, or record expected
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/model/FraudRule.java:[10,1] class, interface, enum, or record expected
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
coder@4bc7b6c0c98f:~/Workspace/demo$ 