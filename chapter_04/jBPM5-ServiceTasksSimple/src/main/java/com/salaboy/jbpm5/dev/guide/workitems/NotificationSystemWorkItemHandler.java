/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package com.salaboy.jbpm5.dev.guide.workitems;

import java.util.HashMap;
import java.util.Map;
import org.drools.runtime.process.WorkItem;
import org.drools.runtime.process.WorkItemHandler;
import org.drools.runtime.process.WorkItemManager;


/**
 *
 * @author salaboy
 */
public class NotificationSystemWorkItemHandler implements WorkItemHandler {

    private long workItemId;
    private Map<String, Object> input;
    public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
        System.out.println(">>>> Sending Notification -> "+workItem.getId());
        workItemId = workItem.getId();
        input = workItem.getParameters();
        System.out.println(">>>>> For Process Instance -> " + workItem.getProcessInstanceId());
        System.out.println(">>>>> Variables: ");
        for (String key : workItem.getParameters().keySet()) {
            System.out.println(">>>>>>> Key: " + key + "  -- Value: " + workItem.getParameter(key));
        }
        Map<String, Object> results = new HashMap<String, Object>();
        results.put("checkinresults_notified", "true");
        manager.completeWorkItem(workItemId, results);
    }

    public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public long getWorkItemId() {
        return workItemId;
    }

    public Map<String, Object> getInput() {
        return input;
    }
    
    
}
