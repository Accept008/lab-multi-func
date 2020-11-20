.PHONY: all
all: fun-deploy

fun-build:
	@cd deployments/$(RUN_ENV) && fun build

# Invoke Event Function
fun-local-invoke:
	@cd deployments/$(RUN_ENV) && fun local invoke -d 3000  -e ./param.json lab-multi-distribute-func

# Invoke Http Function
fun-local-start:
	@cd deployments/$(RUN_ENV) && fun local start


fun-deploy:
	@cd deployments/$(RUN_ENV) && fun deploy

#Apply Function Compute cmd -> make RUN_ENV=qa