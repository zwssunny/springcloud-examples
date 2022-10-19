# Spring Cloud Samples

Samples for spring cloud alibaba. This project contains several sub-projects, each of which is an example of integration with other projects. such as eureka,gateway,openfeign,hystrix,nacos,sentinel,seata...

<img src="https://github.com/alibaba/nacos/blob/develop/doc/Nacos_Logo.png" width="50%" syt height="50%" />


## Nacos: Dynamic  *Na*ming and *Co*nfiguration *S*ervice

Nacos (official site: [nacos.io](https://nacos.io)) is an easy-to-use platform designed for dynamic service discovery and configuration and service management. It helps you to build cloud native applications and microservices platform easily.
Service is a first-class citizen in Nacos. Nacos supports almost all type of services，for example，[Dubbo/gRPC service](https://nacos.io/en-us/docs/use-nacos-with-dubbo.html), [Spring Cloud RESTFul service](https://nacos.io/en-us/docs/use-nacos-with-springcloud.html) or [Kubernetes service](https://nacos.io/en-us/docs/use-nacos-with-kubernetes.html).
Nacos provides four major functions.

* **Service Discovery and Service Health Check** 
 
    Nacos makes it simple for services to register themselves and to discover other services via a DNS or HTTP interface. Nacos also provides real-time health checks of services to prevent sending requests to unhealthy hosts or service instances.

* **Dynamic Configuration Management**
  
    Dynamic Configuration Service allows you to manage configurations of all services in a centralized and dynamic manner across all environments. Nacos eliminates the need to redeploy applications and services when configurations are updated, which makes configuration changes more efficient and agile.

* **Dynamic DNS Service**
    
    Nacos supports weighted routing, making it easier for you to implement mid-tier load balancing, flexible routing policies, flow control, and simple DNS resolution services in the production environment within your data center. It helps you to implement DNS-based service discovery easily and prevent applications from coupling to vendor-specific service discovery APIs.

* **Service and MetaData Management**
	
    Nacos provides an easy-to-use service dashboard to help you manage your services metadata, configuration, kubernetes DNS, service health and metrics statistics.


<img src="https://user-images.githubusercontent.com/9434884/43697219-3cb4ef3a-9975-11e8-9a9c-73f4f537442d.png" alt="Sentinel Logo" width="50%">


## Sentinel: The Sentinel of Your Microservices

As distributed systems become increasingly popular, the reliability between services is becoming more important than ever before.
Sentinel takes "flow" as breakthrough point, and works on multiple fields including **flow control**,
**traffic shaping**, **circuit breaking** and **system adaptive protection**, to guarantee reliability and resilience for microservices.


<img src="https://github.com/seata/seata-samples/blob/master/doc/img/seata.png"  height="100" width="426">

# seata
A distributed transaction solution with high performance and ease of use for microservices architecture.
