package com.xy.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDateTime;

@Data
@Document(indexName = "log")
public class LogModel {
    @Id
    @Field(type = FieldType.Keyword)
    private String segmentId;

    @Field(type = FieldType.Keyword)
    private String reqTxHash;

    @Field(type = FieldType.Keyword)
    private String resTxHash;

    @Field(type = FieldType.Keyword)
    private String reqId;

    @Field(type = FieldType.Keyword)
    private String traceType;

    @Field(type = FieldType.Date, format = DateFormat.basic_date_time)
    private LocalDateTime startTime;

    @Field(type = FieldType.Date, format = DateFormat.year_month_day)
    private LocalDateTime endTime;

    @Field(type = FieldType.Integer, index = false)
    private long cost;

    @Field(type = FieldType.Keyword)
    private String isSync;

    @Field(type = FieldType.Keyword, copyTo = "service")
    private String serviceId;
    private String serviceMethod;
    private String serviceDomain;
    private String serviceContractAddr;
    private String serviceContractMethod;
    private String callerDomain;
    private String callerContractAddr;

    @Field(type = FieldType.Text)
    private String errorCode;

    @Field(type = FieldType.Text)
    private String errorMsg;

}
