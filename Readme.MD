# Sample Json Serializer - Contains Basic Annotation Example

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/5e46917a22b94e5b861dc7a40d72e4fd)](https://app.codacy.com/manual/shangeeth95/SampleJsonSerializer?utm_source=github.com&utm_medium=referral&utm_content=shangeethsivan/SampleJsonSerializer&utm_campaign=Badge_Grade_Dashboard)

This Serializer(ChikuSerializer) was created to learn how annotation works on Java / Kotlin.
The code is written is kotlin.

The idea was to have a class annotated with
custom annotations and get the object of that class converted into Json String
or any format as needed.

This sample shows how reflection api is used when working with annotations 
and how powerful annotations can be.

https://www.baeldung.com/java-custom-annotation You can follow this link to learn how to create annotation
the sample her is present in java format in that blog. I too followed that but did it in kotlin.

##Sample output:

The Person class is converted to json object (not a perfect json obj).
{name=Kumar, age=56, home_town=Trichy}
