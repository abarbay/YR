package nestedclasses.dns;

import java.util.ArrayList;
import java.util.List;

public class NameServer {

    List<DnsEntry> dnsEntries = new ArrayList<>();

    public void addEntry(String hostName, String hostIp) {
        if (dnsEntries.size() == 0) {
            dnsEntries.add(new DnsEntry(hostName, hostIp));
        } else {
            boolean isDuplicate = false;
            for (DnsEntry dns : dnsEntries) {
                if (dns.getHostName().equals(hostName) || dns.getHostIp().equals(hostIp)) {
                    isDuplicate = true;
                    break;
                }
            }
            if (isDuplicate) {
                throw new IllegalArgumentException("Already exists");
            } else {
                dnsEntries.add(new DnsEntry(hostName, hostIp));
            }
        }
    }

    public void removeEntryByName(String hostName) {
        int index = -1;
        for (DnsEntry dns : dnsEntries) {
            if (dns.getHostName().equals(hostName)) {
                index = dnsEntries.indexOf(dns);
                break;
            }

        }
        if (index != -1) {
            dnsEntries.remove(index);
        } else {
            throw new IllegalArgumentException("Element not found");
        }
    }

    public void removeEntryByIp(String hostIp) {
        int index = -1;
        for (DnsEntry dns : dnsEntries) {
            if (dns.getHostIp().equals(hostIp)) {
                index = dnsEntries.indexOf(dns);
                break;
            }

        }
        if (index != -1) {
            dnsEntries.remove(index);
        } else {
            throw new IllegalArgumentException("Element not found");
        }
    }

    public String getIpByName(String hostName) {
        boolean isFound = false;
        String result = null;
        for (DnsEntry dns : dnsEntries) {
            if (dns.getHostName().equals(hostName)) {
                isFound = true;
                result = dns.getHostIp();
                break;
            }
        }
        if (isFound) {
            return result;
        } else {
            throw new IllegalArgumentException("Element not found");
        }
    }

    public String getNameByIp(String hostIp) {
        boolean isFound = false;
        String result = null;
        for (DnsEntry dns : dnsEntries) {
            if (dns.getHostIp().equals(hostIp)) {
                isFound = true;
                result = dns.getHostName();
                break;
            }
        }
        if (isFound) {
            return result;
        } else {
            throw new IllegalArgumentException("Element not found");
        }
    }

    private static class DnsEntry {
        private String hostName;
        private String hostIp;

        public DnsEntry(String hostName, String hostIp) {
            this.hostName = hostName;
            this.hostIp = hostIp;
        }

        public String getHostName() {
            return hostName;
        }

        public String getHostIp() {
            return hostIp;
        }

    }

}
