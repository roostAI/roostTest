<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
            <executions>
                <execution>
                    <id>spring-javaformat</id>
                    <goals>
                        <goal>apply</goal>
                    </goals>
                    <phase>pre-integration-test</phase>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
