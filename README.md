# Kathara Panda

## Authors

[Raphaël Dray](https://www.linkedin.com/in/raphaeldray/) <br>
[Clara Nacache](https://www.linkedin.com/in/claranacache/) <br>
[Thierry Khamphousone](https://www.linkedin.com/in/tkhamphousone/) <br>

<br>

## Introduction 

[Kathara](https://www.kathara.org) is a network emulation system based on Docker where each device is emulated by an unique container which is interconnected by virtual L2 LANs, and each container can run a Docker image. Kathara is helpful to develop new network protocols within a testing network sandbox environment. It is a NetKit implementation.

<p align="center" width="100%">
    <img align="center" width="554" height="136" src="./pictures/logo.png"/>
</p>

<hr><br>

## How does it work?

### Run Kathara's clusters

__Requirements:__
- [Kathara installation](https://github.com/KatharaFramework/Kathara/wiki)
- [Docker installation](https://www.docker.com/get-started)
<br>

__Important:__ 

Kathara needs Docker to be running to start computers. So you must run Docker before Kathara lab.

```bash
#Start the project by looking at the lab.conf definitions
> kathara lstart

#Stop all computers started from the lab.conf file
> kathara wipe
```

## Project description 

### Network Schema

<p align="center" width="100%">
    <img align="center" width="946" height="789" src="./pictures/network.png"/>
</p>

<br>

### Network Configuration

<p align="center" width="100%">
    <img align="center" width="957" height="394" src="./pictures/lab_mapping_with_ip_configured.png"/>
</p>

<br>


### Configuration explanations
- [__router1__](https://github.com/MrrRaph/Kathara-Panda/blob/master/router1.startup): Communication between subnet A and subnet C
- [__router2__](https://github.com/MrrRaph/Kathara-Panda/blob/master/router2.startup): Communication between subnet D and subnet B
- [__router3__](https://github.com/MrrRaph/Kathara-Panda/blob/master/router3.startup): Communication between subnet C and subnet B
- [__Client__](https://github.com/MrrRaph/Kathara-Panda/blob/master/client.startup): Get the HTML from the Java Web Server through Domain name
- [__DNS Server__](https://github.com/MrrRaph/Kathara-Panda/blob/master/dns_server.startup): Define domain names and aliases
- [__Java Web Server__](https://github.com/MrrRaph/Kathara-Panda/blob/master/java_web_server.startup): Uses as a Proxy for getting the HTML from the Static Web Server
- [__Static Web Server__](https://github.com/MrrRaph/Kathara-Panda/blob/master/static_web_server.startup): Serves HTML pages

<br>

#### Devices emulated by Docker containers

<p align="center" width="100%">
    <img align="center" width="998" height="445" src="./pictures/docker.png"/>
</p>

<hr> <br>

## Lab testing

```bash
> traceroute www.panda-crew.com     
traceroute to www.panda-crew.com (172.16.0.100), 30 hops max, 60 byte packets
 1  192.168.0.254 (192.168.0.254)  0.105 ms  0.027 ms  0.014 ms
 2  10.20.30.254 (10.20.30.254)  0.036 ms  0.026 ms  0.026 ms
 3  jws.panda-crew.com (172.16.0.100)  0.051 ms  0.040 ms  0.040 ms

> links http://www.panda-crew.com:1111
```
<br>
<p align="center" width="100%">
    <img align="center" width="893" height="941" src="./pictures/panda.png"/>
</p>

<br>

