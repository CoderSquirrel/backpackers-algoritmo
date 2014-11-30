# README #

This README would normally document whatever steps are necessary to get your application up and running.

## Methods ##

### readRquestFile() ###
* Parameter JSONObject
* Return  Double[],[]
* Input Exemple

```
#!json

    {
       "prices":[
       { 
		      "0":{
	             "price":0
	          },
	          "1":{
	             "price":9.99
	          },
	          "2":{
	             "price":22.99
	          },
	         "3": {
	             "price":19.99
	          }
          },
          {
	          "0":{
	             "price":12.50
	          },
			  "1":{
	             "price":0
	          },
	         "2": {
	             "price":35.99
	          },
	         "3": {
	             "price":59.26
	          }
	      },
          {
	         "0": {
	             "price":22.99
	          },
	         "1": {
	             "price":26.36
	          },
	          "2":{
	             "price":0
	          },
	          "3":{
	             
	             "price":19.60
	          }
          },
          {
	          "0":{
	             "price":19.99
	          },
	          "1":{
	             "price":49.52
	          },
	         "2": {
	             "price":39.59
	          },
	         "3": {
	             "price":0
	          }
          }
       ]
    }
```

* Output Exemple

```
#!java
0.0 | 9.99 | 22.99 | 19.99 | 
12.5 | 0.0 | 35.99 | 59.26 | 
22.99 | 26.36 | 0.0 | 19.6 | 
19.99 | 49.52 | 39.59 | 0.0 | 
```


### sendResponseFile() ###
* Parameter Trajeto
* Return JSONObject
* Output exemple

```
#!json

{
   "price":85.57000000000001,
   "routs":[
      1,
      2,
      3
   ]
}
```