# Weather Demo App
This is a demo app to show Pivotal Cloud Foundry and Spring Boot

## Usage
You can open `src/main/resources/application.yml` and change the `city` and `company` value to any default city you like.

To run it, you will need to compile it:

```
# Windows
compile.cmd

# Linux / Mac
./compile
```

Once it's compiled you can push it to cloud foundry:

```
cf push
```

You can then demo things like Actuator etc.
