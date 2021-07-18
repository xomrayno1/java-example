# java-example
Elastic search , add logback
<p>http://localhost:9200/_cat/indices?format=json : Liệt kê tất cả các index</p>
<p>http://localhost:9200/customer hiển thị index customer</p>
<p>http://localhost:9200/ hiển thị thông tin version, cluster</p>
<p>http://localhost:9200/_cat/nodes?format=json hiển thị thông tin nodes</p>
<p>http://localhost:9200/customer/_doc/3 get customer id = 3</p>
<hr>
<p>http://localhost:8080/api/v1/vehicle/search Tìm kiếm<p>
<div>
Method: Post,  </br>
Params: { </br>
    "fields" : ["name"], </br>
    "searchTerm" : "TTT",  </br>
    "sortBy" : "id",  </br>
    "order" : "DESC" </br>
} </br>
</div>

<p>http://localhost:8080/api/v1/vehicle Thêm, sửa</p>
<div>
Method: Post, </br>
Params: { </br>
    "id" : 4, </br>
    "number" : "952-153", </br>
    "name" : "TTT 4", </br>
    "created" : "2021-07-16" </br>
}
</div>
