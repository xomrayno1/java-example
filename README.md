# java-example
Elastic search , add logback
http://localhost:9200/_cat/indices?format=json : Liệt kê tất cả các index
http://localhost:9200/customer hiển thị index customer
http://localhost:9200/ hiển thị thông tin version, cluster
http://localhost:9200/_cat/nodes?format=json hiển thị thông tin nodes
http://localhost:9200/customer/_doc/3 get customer id = 3

http://localhost:8080/api/v1/vehicle/search Tìm kiếm
Method: Post, 
Params: {
    "fields" : ["name"],
    "searchTerm" : "TTT",
    "sortBy" : "id",
    "order" : "DESC"
}

http://localhost:8080/api/v1/vehicle Thêm, sửa
Method: Post,
Params: {
    "id" : 4,
    "number" : "952-153",
    "name" : "TTT 4",
    "created" : "2021-07-16"
}
