package io.choerodon.issue.domain;

import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.choerodon.mybatis.domain.AuditDomain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

/**
 * @author peng.jiang@hand-china.com
 */
@ModifyAudit
@VersionAudit
@Table(name = "state_machine_scheme")
public class StateMachineScheme extends AuditDomain {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private String status;
    private Long organizationId;
    private Integer deployProgress;
    private String deployStatus;

    @Transient
    private List<StateMachineSchemeConfig> schemeConfigs;
    @Transient
    private List<ProjectConfig> projectConfigs;

    public Integer getDeployProgress() {
        return deployProgress;
    }

    public void setDeployProgress(Integer deployProgress) {
        this.deployProgress = deployProgress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public List<StateMachineSchemeConfig> getSchemeConfigs() {
        return schemeConfigs;
    }

    public void setSchemeConfigs(List<StateMachineSchemeConfig> schemeConfigs) {
        this.schemeConfigs = schemeConfigs;
    }

    public List<ProjectConfig> getProjectConfigs() {
        return projectConfigs;
    }

    public void setProjectConfigs(List<ProjectConfig> projectConfigs) {
        this.projectConfigs = projectConfigs;
    }

    public String getDeployStatus() {
        return deployStatus;
    }

    public void setDeployStatus(String deployStatus) {
        this.deployStatus = deployStatus;
    }
}
