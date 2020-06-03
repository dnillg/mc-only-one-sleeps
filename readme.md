#Only one sleeps
By default all players have to sleep in their beds to make morning on the server. The plugin modifies this behavior and **requires only one player**.

####Key facts:
Lightweight solution for making mornings by one player in community servers
Supports permissions
Source code available

####Configuration nodes and default values:
```yaml
permissions:
  enabled: false #has to be enabled when using permissions
sleepDelay: 4
change:
  weather:
    enabled: true
  time:
    enabled: true
    value: 0
```

####Plugin homepage: 
https://www.spigotmc.org/resources/only-one-sleeps.79657/