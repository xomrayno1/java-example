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

<hr>
<div>
    <table>
        <tr>
            <th>SQL-based</th>
            <th>Elasticsearch</th>
        </tr>
        <tr>
            <td>Database</td>
            <td>Index</td>
        </tr>
        <tr>
            <td>Tables</td>
            <td>Type</td>
        </tr>
        <tr>
            <td>Rows</td>
            <td>Documents</td>
        </tr>
    </table>
</div>

<p>Boolean query:</p>
A query that matches documents matching boolean combinations of other queries. The bool query maps to Lucene BooleanQuery. It is built using one or more boolean clauses, each clause with a typed occurrence. The occurrence types are: <br>

must - the clause (query) must appear in matching documents and will contribute to the score. <br>

filter - the clause (query) must appear in matching documents. However unlike must the score of the query will be ignored. Filter clauses are executed in filter context, meaning that scoring is ignored and clauses are considered for caching.<br>

should - the clause (query) should appear in the matching document.<br>

must_not - the clause (query) must not appear in the matching documents. Clauses are executed in filter context meaning that scoring is ignored and clauses are considered for caching. Because scoring is ignored, a score of 0 for all documents is returned.<br>


