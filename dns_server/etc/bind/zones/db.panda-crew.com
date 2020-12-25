$TTL	604800
@	IN	SOA	giga.panda-crew.com.	admin.panda-crew.com.	(
				3	    ; Serial
			   604800	    ; Refresh
			    86400	    ; Retry
			  2419200	    ; Expire
			   604800  )	    ; Negative Cache TTL

; name servers - NS records
	IN	NS	giga.panda-crew.com.

; name servers - A records
giga.panda-crew.com.	IN	A	192.168.100.100

; hosts - A records
jws.panda-crew.com.	IN	A	172.16.0.100
sws.panda-crew.com.	IN	A	10.20.30.100
