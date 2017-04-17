Scala Play Client, Read Restful Results
=======================================
Simple Scala client for quering ElasticSeatch data from Rest-ful API, using play framework and bootstrap.

Controllers
===========

- `HomeController.scala`:
Contains Index and Search actions to submit search request from Resultfule API, and view results.


And here's sample of the parsed result:

```json
{ 
	"took": 9, 
    "timed_out": false,
    "_shards": { 
    	"total": 5, 
        "successful": 5, 
        "failed": 0 
    }, 
    "hits": { 
    	"total": "1660", 
        "max_score": 1.0, 
        "hits": [ 
        	{ "_id": "AVhxgJoz9xhc9lFllVgn", "id": 9599 }, 
            { "_id": "AVhxgJs_9xhc9lFllVgp", "id": 9601 } 
         ] 
    } 
}
```


Dependencies
============
- [Play Framework](https://www.playframework.com/) high velocity web framework for Scala
- [Bootstrap](http://getbootstrap.com/) HTML, CSS and JS framework for developing responsive web applications.

