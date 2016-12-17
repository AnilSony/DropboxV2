package de.donmanfred.dbxv2.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.v2.DbxRawClientV2;
import com.dropbox.core.v2.async.LaunchEmptyResult;
import com.dropbox.core.v2.files.DbxUserFilesRequests;
import com.dropbox.core.v2.files.DeleteArg;
import com.dropbox.core.v2.files.DeleteBatchError;
import com.dropbox.core.v2.files.DeleteBatchJobStatus;
import com.dropbox.core.v2.files.DownloadBuilder;
import com.dropbox.core.v2.files.DownloadErrorException;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.FolderMetadata;
import com.dropbox.core.v2.files.GetCopyReferenceResult;
import com.dropbox.core.v2.files.GetTemporaryLinkResult;
import com.dropbox.core.v2.files.ListFolderErrorException;
import com.dropbox.core.v2.files.ListFolderGetLatestCursorResult;
import com.dropbox.core.v2.files.ListFolderLongpollErrorException;
import com.dropbox.core.v2.files.ListFolderLongpollResult;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.ListRevisionsResult;
import com.dropbox.core.v2.files.Metadata;
import com.dropbox.core.v2.files.MoveBatchBuilder;
import com.dropbox.core.v2.files.RelocationBatchError;
import com.dropbox.core.v2.files.RelocationBatchJobStatus;
import com.dropbox.core.v2.files.RelocationPath;
import com.dropbox.core.v2.files.SaveUrlErrorException;
import com.dropbox.core.v2.files.SaveUrlJobStatus;
import com.dropbox.core.v2.files.SaveUrlResult;
import com.dropbox.core.v2.files.SearchMatch;
import com.dropbox.core.v2.files.SearchMode;
import com.dropbox.core.v2.files.SearchResult;
import com.dropbox.core.v2.files.ThumbnailFormat;
import com.dropbox.core.v2.files.ThumbnailSize;
import com.dropbox.core.v2.files.UploadErrorException;
import com.dropbox.core.v2.files.UploadSessionAppendUploader;
import com.dropbox.core.v2.files.UploadSessionStartResult;
import com.dropbox.core.v2.files.UploadSessionStartUploader;
import com.dropbox.core.v2.files.WriteMode;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Events;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.objects.collections.List;
import anywheresoftware.b4a.objects.collections.Map;

@ShortName("DbxUserFilesRequests")
//@Permissions(values={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
@Events(values={
		"CreateFolder(success As boolean, meta As FolderMetadata, error As String)",
		"Copy(success As boolean, meta As Metadata, error As String)",
		"CopyBatch(success As boolean, meta As Map, error As String)",
		"CopyBatchCheck(success As boolean, meta As Map, error As String)",
		"CopyReference(metainfo As Map)",
		"DownloadFinished(success As boolean, meta As FileMetadata, error As String)",
		"LatestCursor(success As boolean, path As String, cursor As String, error As String)",
		"ListFolder(success As boolean, content As List, error As String)",
		"ListFolderLatestCursor(success As boolean, content As List, error As String)",
		"ListRevisions(success As boolean, meta As Map, error As String)",
		"Move(success As boolean, meta As Metadata, error As String)",
		"MoveBatch(success As boolean, meta As Map, error As String)",
		"MoveBatchCheck(success As boolean, meta As Map, error As String)",
		"Preview(success As boolean, meta As FileMetadata, error As String)",
		"Restore(success As boolean, meta As FileMetadata, error As String)",
		"SaveURL(success As boolean, meta As Map, info As String)",
		"SaveURLJobStatus(success As boolean, meta As Map, info As String)",
		"TemporaryLink(success As boolean, path As String, link As String, meta As FileMetadata)",
		"UploadFinished(success As boolean, meta As FileMetadata, error As String)",
		"UploadSessionFinished(session As Map)",
		"UploadSessionProgress(session As Map)"
})

public class DbxUserFilesRequestsWrapper extends AbsObjectWrapper<DbxUserFilesRequests> {
	private BA ba;
	private String eventName;

	@Hide
	public void Initialize(final BA ba, String EventName, DbxRawClientV2 client) {
		this.eventName = EventName.toLowerCase(BA.cul);
		this.ba = ba;

		final DbxUserFilesRequests _obj = new DbxUserFilesRequests(client);
		final String eventName = EventName.toLowerCase(BA.cul);
		setObject(_obj);

		// Missing
		//getObject().listFolderLongpoll(cursor)
		//getObject().listFolderLongpoll(cursor, timeout)
		//getObject().permanentlyDelete(path);
		//getObject().uploadSessionAppend(sessionId, offset)
		//getObject().uploadSessionAppendV2(cursor)
		//getObject().uploadSessionAppendV2(cursor, close)
		//getObject().uploadSessionFinish(cursor, commit)
		//getObject().uploadSessionFinishBatch(entries)
		//getObject().uploadSessionStart()
		//getObject().uploadSessionStart(close)
		
	}
	
	public void listFolderLongpoll(String cursor){		
		new Thread(new Runnable() {
      @Override
      public void run() {
      	ba.Log("dummy()");
      	try {
					ListFolderLongpollResult result = getObject().listFolderLongpoll(cursor);

				} catch (ListFolderLongpollErrorException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (DbxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
      	//ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_dummy", true, new Object[] {result});
      }
		}).start();
	}
	
	public void uploadtest(final String destfile, final String localPath, final String localFilename){		
		new Thread(new Runnable() {
      private byte[] buffer;

			@Override
      public void run() {
      	ba.Log("upload()");
      	UploadSessionStartUploader uploader = null;
      	try {
      		uploader = getObject().uploadSessionStart(false);
      		
      		UploadSessionStartResult uplsession = uploader.finish();
      		File localFile = new File(localPath, localFilename);
        	long lengthLocalFile = localFile.length();
        	//UploadSessionStartResult uplsess = uploader
        	int offset = 0;
        	Map session = new Map();
        	session.Initialize();
        	session.Put("SessionId", uplsession.getSessionId());
        	session.Put("FileLength", lengthLocalFile);
        	session.Put("Offset", offset);
        	session.Put("Finished", false);
        	OutputStream ost = uploader.getOutputStream();
        	
        	buffer = new byte[1024*128];
        	InputStream inpstr = new FileInputStream(localFile);
    			while (true) {
          	ba.Log("Bytes available from Inputstream: "+inpstr.available());
          	if (inpstr.available() > 1024*128){
          		int bread = inpstr.read(buffer, 0, 1024*128);
          		ost.write(buffer);
            	//ost.flush();
          		//uploader.getOutputStream().write(buffer, 0, bread );
            	//uploader.getOutputStream().flush();
            	
            	offset = offset + bread;
            	session.Put("Offset", offset);
            	session.Put("BytesLeft", inpstr.available());
            	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_uploadsessionprogress", true, new Object[] {session});
          	} else {
          		int bread = inpstr.read(buffer, 0, inpstr.available());
            	ost.write(buffer, 0,bread);
            	ost.flush();
            	ost.close();
            	offset = offset + bread;
            	session.Put("Offset", offset);
            	session.Put("Finished", true);
            	session.Put("BytesLeft", inpstr.available());
            	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_uploadsessionprogress", true, new Object[] {session});
            	
          	}
						//pba.Log("files:listFolder(while)");
						//for (Metadata metadata : result.getEntries()) {
						//	//pba.Log("listFolder(l.add(meta))");
						//	l.Add(metadata);
						//}	
						if (!(inpstr.available() > 0)) {
							break;
						}
						///result = getObject().listFolderContinue(result.getCursor());
						//pba.Log("files:listFolder(result filled)");
					}
        	inpstr.close();        	
        	uploader.close();
        	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_uploadsessionfinished", true, new Object[] {session});
	      	//ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_uploadfinished", true, new Object[] {true,metadata,"OK"});

        	
        	
        	//int data = inpstr.read(buffer, int offset, int length) .read();
        	//while(data != -1) {
        	  //do something with data...
        	  //doSomethingWithData(data);

        	  //data = inpstr.read();
        	//}
        	//ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_dummy", true, new Object[] {result});
        	

      	} catch (DbxException e) {
        	ba.Log("DbxException: "+e.getMessage());
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
        	ba.Log("FileNotFoundException: "+e.getMessage());
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
        	ba.Log("IOException: "+e.getMessage());
					e.printStackTrace();
				}
      }
		}).start();
	}
	
	public void moveBatch(final java.util.List<RelocationPath> relocation, final boolean allowSharedFolder, final boolean autorename){	
	
		new Thread(new Runnable() {
      @Override
      public void run() {
      	ba.Log("moveBatch()");
      	try {
      		
      		LaunchEmptyResult result = getObject().moveBatchBuilder(relocation).withAllowSharedFolder(allowSharedFolder).withAutorename(autorename).start();
					Map m = new Map();
					m.Initialize();
					m.Put("AsyncJobId", result.getAsyncJobIdValue());
					m.Put("isAsyncJobId", result.isAsyncJobId());
					m.Put("isComplete", result.isComplete());
					m.Put("Tag", result.tag());
					m.Put("RelocationPath", relocation);
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_movebatch", true, new Object[] {true,m,"movebatchcreated"});
				} catch (DbxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_movebatch", true, new Object[] {false,null,e.getMessage()});
				}
      }
		}).start();
	}
	public void MoveBatchCheck(final String asyncJobId){		
		new Thread(new Runnable() {
      @Override
      public void run() {
      	ba.Log("dummy()");
      	RelocationBatchJobStatus result;
				try {
					result = getObject().moveBatchCheck(asyncJobId);
					Map m = new Map();
					m.Initialize();

					m.Put("isInProgress", result.isInProgress());
					m.Put("isComplete", result.isComplete());
					m.Put("isFailed", result.isFailed());
					if (result.isFailed() == true){
						Map err = new Map();
						err.Initialize();

						RelocationBatchError failed = result.getFailedValue();
						err.Put("FromLookup", failed.getFromLookupValue().toString() );
						err.Put("FromWrite", failed.getFromWriteValue().toString() );
						err.Put("To", failed.getToValue().toString() );
						err.Put("isCantCopySharedFolder", failed.isCantCopySharedFolder() );
						err.Put("isCantMoveFolderIntoItself", failed.isCantMoveFolderIntoItself() );
						err.Put("isCantNestSharedFolder", failed.isCantNestSharedFolder() );
						err.Put("isDuplicatedOrNestedPaths", failed.isDuplicatedOrNestedPaths() );
						err.Put("isFromLookup", failed.isFromLookup() );
						err.Put("isFromWrite", failed.isFromWrite() );
						err.Put("isOther", failed.isOther() );
						err.Put("isTo", failed.isTo() );
						err.Put("isTooManyFiles", failed.isTooManyFiles() );
						err.Put("isTooManyWriteOperations", failed.isTooManyWriteOperations() );
						m.Put("FailedInfo", err);
					}
					if (result.isComplete() == true){
						m.Put("Entries", result.getCompleteValue().getEntries());						
					}
					m.Put("Tag", result.tag());

					ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_movebatchcheck", true, new Object[] {true,m,"movebatchchecked"});
				} catch (DbxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_movebatchcheck", true, new Object[] {false,null,e.getMessage()});
				}
      }
		}).start();
	}
	public void move(final String fromPath,final String toPath){		
		new Thread(new Runnable() {
      @Override
      public void run() {
      	ba.Log("files.move()");
      	Metadata result;
				try {
					result = getObject().move(fromPath, toPath);
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_move", true, new Object[] {true,AbsObjectWrapper.ConvertToWrapper(new MetadataWrapper(), result),"OK"});
				} catch (DbxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_move", true, new Object[] {false,null,e.getMessage()});
				}
      }
		}).start();
	}
	public void getTemporaryLink(final BA pba, final String path) throws DbxException{		
		new Thread(new Runnable() {
      @Override
      public void run() {
      	ba.Log("files.getTemporaryLink()");
				List l = new List();
    		l.Initialize();

      	GetTemporaryLinkResult result;
				try {
					result = getObject().getTemporaryLink(path);;
					//	result = getObject().listFolder(path);
					//pba.Log("files:listFolder(result filled)");
					ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_temporarylink", true, new Object[] {true, path, result.getLink(),result.getMetadata()});
				} catch (ListFolderErrorException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_temporarylink", true, new Object[] {false,path, "",null,e.getMessage()});
				} catch (DbxException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_temporarylink", true, new Object[] {false,path, "",null,e.getMessage()});
				}
      }
		}).start();
	}
	public void saveUrlCheckJobStatus(final String asyncJobId){		
		new Thread(new Runnable() {
      @Override
      public void run() {
      	ba.Log("saveUrl()");
      	try {
					SaveUrlJobStatus result = getObject().saveUrlCheckJobStatus(asyncJobId);
					Map m = new Map();
					m.Initialize();
					m.Put("isComplete", result.isComplete());
					m.Put("isFailed", result.isFailed());
					m.Put("isInProgress", result.isInProgress());
					m.Put("Tag", result.tag());
					if (result.isComplete()){
						m.Put("meta", result.getCompleteValue());						
					}
					if (result.isFailed()){
						m.Put("error", result.getFailedValue());						
					}
					ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_saveurljobstatus", true, new Object[] {true,m,"saveurljob_checked"});
				} catch (SaveUrlErrorException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_saveurljobstatus", true, new Object[] {false,null,e.getMessage()});
				} catch (DbxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_saveurljobstatus", true, new Object[] {false,null,e.getMessage()});
				}
      	//ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_dummy", true, new Object[] {result});
      }
		}).start();
	}
	public void saveUrl(final String path, final String url){		
		new Thread(new Runnable() {
      @Override
      public void run() {
      	ba.Log("saveUrl()");
      	try {
					SaveUrlResult result = getObject().saveUrl(path, url);
					Map m = new Map();
					m.Initialize();
					m.Put("AsyncJobId", result.getAsyncJobIdValue());
					m.Put("isAsyncJobId", result.isAsyncJobId());
					m.Put("isComplete", result.isComplete());
					m.Put("Tag", result.tag());
					m.Put("URL", url);
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_saveurl", true, new Object[] {true,m,"saveurljob_created"});
				} catch (SaveUrlErrorException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_saveurl", true, new Object[] {false,null,e.getMessage()});
				} catch (DbxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_saveurl", true, new Object[] {false,null,e.getMessage()});
				}
      	//ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_dummy", true, new Object[] {result});
      }
		}).start();
	}
	public void setEventname(final BA ba, final String EventName) {
		this.eventName = EventName.toLowerCase(BA.cul);
		this.ba = ba;
	}

	public void dummy2(){		
		new Thread(new Runnable() {
      @Override
      public void run() {
      	ba.Log("dummy()");
      	//result = getObject();
      	//ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_dummy", true, new Object[] {result});
      }
		}).start();
	}
	public void getThumbnail(final String path, final ThumbnailFormat format, final ThumbnailSize size, final String localPath, final String localFilename){		
		new Thread(new Runnable() {
      private Object result;

			@Override
      public void run() {
      	ba.Log("files.getThumbnail()");
      	try {
        	File localFile = new File(localPath, localFilename);
      		FileOutputStream fos = null;
      		ba.Log("files.getThumbnail(create fos)");
      		fos = new FileOutputStream(localFile);
        	ba.Log("files.getThumbnail(fos created)");
      		DbxDownloader<FileMetadata> result = null;
					try {
						result = getObject().getThumbnailBuilder(path).withFormat(format).withSize(size).start();
		      	ba.Log("files.getThumbnail(got DbxDownloader<FileMetadata> result)");
						FileMetadata meta;
						try {
							meta = result.download(fos);
			      	ba.Log("files.download(after download");
							ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_preview", true, new Object[] {true, AbsObjectWrapper.ConvertToWrapper(new FileMetadataWrapper(), meta),"OK"});
						} catch (DbxException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_preview", true, new Object[] {false, null,e.getMessage()});
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_preview", true, new Object[] {false, null,e.getMessage()});
						}
					} catch (DownloadErrorException e) {
						// TODO Auto-generated catch block
						ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_preview", true, new Object[] {false, null,e.getMessage()});
						e.printStackTrace();
					} catch (DbxException e) {
						// TODO Auto-generated catch block
						ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_preview", true, new Object[] {false, null,e.getMessage()});
						e.printStackTrace();
					}
      	} catch (FileNotFoundException e) {
      		// TODO Auto-generated catch block
					ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_preview", true, new Object[] {false, null,e.getMessage()});
      		e.printStackTrace();
      	}
      	
      	//ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_dummy", true, new Object[] {result});
      }
		}).start();
	}
	public void getPreview(final String path, final String localPath, final String localFilename){		
		new Thread(new Runnable() {
      private Object result;

			@Override
      public void run() {
      	ba.Log("dummy()");
      	try {
        	File localFile = new File(localPath, localFilename);
      		FileOutputStream fos = null;
      		ba.Log("files.download(create fos)");
      		fos = new FileOutputStream(localFile);
        	ba.Log("files.download(fos created)");
      		DbxDownloader<FileMetadata> result = null;
					try {
	      		result = getObject().getPreviewBuilder(path).start();
		      	ba.Log("files.download(got DbxDownloader<FileMetadata> result)");
						FileMetadata meta;
						try {
							meta = result.download(fos);
			      	ba.Log("files.download(after download");
							ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_preview", true, new Object[] {true, AbsObjectWrapper.ConvertToWrapper(new FileMetadataWrapper(), meta),"OK"});
						} catch (DbxException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_preview", true, new Object[] {false, null,e.getMessage()});
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_preview", true, new Object[] {false, null,e.getMessage()});
						}
					} catch (DownloadErrorException e) {
						// TODO Auto-generated catch block
						ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_preview", true, new Object[] {false, null,e.getMessage()});
						e.printStackTrace();
					} catch (DbxException e) {
						// TODO Auto-generated catch block
						ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_preview", true, new Object[] {false, null,e.getMessage()});
						e.printStackTrace();
					}
      	} catch (FileNotFoundException e) {
      		// TODO Auto-generated catch block
					ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_preview", true, new Object[] {false, null,e.getMessage()});
      		e.printStackTrace();
      	}
      	
      	//ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_dummy", true, new Object[] {result});
      }
		}).start();
	}
	public void getPreview2(final String path, final String rev, final String localPath, final String localFilename){		
		new Thread(new Runnable() {
      private Object result;

			@Override
      public void run() {
      	ba.Log("dummy()");
      	try {
        	File localFile = new File(localPath, localFilename);
      		FileOutputStream fos = null;
      		ba.Log("files.download(create fos)");
      		fos = new FileOutputStream(localFile);
        	ba.Log("files.download(fos created)");
      		DbxDownloader<FileMetadata> result = null;
					try {
	      		result = getObject().getPreviewBuilder(path).withRev(rev).start();
		      	ba.Log("files.download(got DbxDownloader<FileMetadata> result)");
						FileMetadata meta;
						try {
							meta = result.download(fos);
			      	ba.Log("files.download(after download");
							ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_preview", true, new Object[] {true, AbsObjectWrapper.ConvertToWrapper(new FileMetadataWrapper(), meta),"OK"});
						} catch (DbxException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_preview", true, new Object[] {false, null,e.getMessage()});
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_preview", true, new Object[] {false, null,e.getMessage()});
						}
					} catch (DownloadErrorException e) {
						// TODO Auto-generated catch block
						ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_preview", true, new Object[] {false, null,e.getMessage()});
						e.printStackTrace();
					} catch (DbxException e) {
						// TODO Auto-generated catch block
						ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_preview", true, new Object[] {false, null,e.getMessage()});
						e.printStackTrace();
					}
      	} catch (FileNotFoundException e) {
      		// TODO Auto-generated catch block
					ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_preview", true, new Object[] {false, null,e.getMessage()});
      		e.printStackTrace();
      	}
      	
      	//ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_dummy", true, new Object[] {result});
      }
		}).start();
	}
	public void deleteBatch(final java.util.List<DeleteArg> entries){		
		new Thread(new Runnable() {
      @Override
      public void run() {
      	ba.Log("deleteBatch()");
      	try {
					
					LaunchEmptyResult result = getObject().deleteBatch(entries);
					Map m = new Map();
					m.Initialize();
					m.Put("AsyncJobId", result.getAsyncJobIdValue());
					m.Put("isAsyncJobId", result.isAsyncJobId());
					m.Put("isComplete", result.isComplete());
					m.Put("Tag", result.tag());
					m.Put("Entries", entries);
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_deletebatch", true, new Object[] {true,m,"deletebatchcreated"});
				} catch (DbxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_deletebatch", true, new Object[] {false,null,e.getMessage()});
				}
      }
		}).start();
	}
	public void deleteBatchCheck(final String batchID){		
		new Thread(new Runnable() {
      @Override
      public void run() {
      	ba.Log("dummy()");
      	DeleteBatchJobStatus result;
				try {
					result = getObject().deleteBatchCheck(batchID);
					Map m = new Map();
					m.Initialize();

					m.Put("isInProgress", result.isInProgress());
					m.Put("isComplete", result.isComplete());
					m.Put("isFailed", result.isFailed());
					if (result.isFailed() == true){
						Map err = new Map();
						err.Initialize();

						DeleteBatchError failed = result.getFailedValue();
						err.Put("failedname", failed.name() );
						m.Put("FailedInfo", err);
					}
					if (result.isComplete() == true){
						m.Put("Entries", result.getCompleteValue().getEntries());						
					}
					m.Put("Tag", result.tag());
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_deletebatchcheck", true, new Object[] {true,m,"batchchecked"});
				} catch (DbxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_deletebatchcheck", true, new Object[] {false,null,e.getMessage()});
				}
      }
		}).start();
	}
	public void moveBatch(final java.util.List<RelocationPath> entries){		
		new Thread(new Runnable() {
      @Override
      public void run() {
      	ba.Log("dummy()");
      	try {
					LaunchEmptyResult result = getObject().moveBatch(entries);
					Map m = new Map();
					m.Initialize();
					m.Put("AsyncJobId", result.getAsyncJobIdValue());
					m.Put("isAsyncJobId", result.isAsyncJobId());
					m.Put("isComplete", result.isComplete());
					m.Put("Tag", result.tag());
					m.Put("Entries", entries);
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_movebatch", true, new Object[] {true,m,"movebatchcreated"});
				} catch (DbxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_movebatch", true, new Object[] {false,null,e.getMessage()});
				}
      }
		}).start();
	}
	public void listRevisions(final String path){		
		new Thread(new Runnable() {
      @Override
      public void run() {
      	ba.Log("listRevisions()");
      	try {
					ListRevisionsResult result = getObject().listRevisions(path);
					Map m = new Map();
					m.Initialize();
					m.Put("isDeleted", result.getIsDeleted());
					List l = new List();
					l.Initialize();
					for (FileMetadata meta: result.getEntries()){
						l.Add(meta);
					}
					m.Put("Entries", l);
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_ListRevisions", true, new Object[] {true,m,"OK"});
				} catch (DbxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_ListRevisions", true, new Object[] {false,null,e.getMessage()});
				}
      }
		}).start();
	}
	public void listRevisions2(final String path, final long limit){		
		new Thread(new Runnable() {
      @Override
      public void run() {
      	ba.Log("dummy()");
      	try {
					ListRevisionsResult result = getObject().listRevisions(path, limit);
					Map m = new Map();
					m.Initialize();
					m.Put("isDeleted", result.getIsDeleted());
					List l = new List();
					l.Initialize();
					for (FileMetadata meta: result.getEntries()){
						l.Add(meta);
					}
					m.Put("Entries", l);
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_ListRevisions", true, new Object[] {true,m,"OK"});
				} catch (DbxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_ListRevisions", true, new Object[] {false,null,e.getMessage()});
				}
      }
		}).start();
	}
	public void delete(final String path){		
		new Thread(new Runnable() {
      @Override
      public void run() {
      	ba.Log("dummy()");
      	Metadata result;
				try {
					result = getObject().delete(path);
					ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_delete", true, new Object[] {true,result,"OK"});
				} catch (DbxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_delete", true, new Object[] {true,null,e.getMessage()});
				}
      }
		}).start();
	}
	public void createFolder2(final String path, final boolean autorename){		
		new Thread(new Runnable() {
      @Override
      public void run() {
      	ba.Log("dummy()");
      	FolderMetadata result;
				try {
					result = getObject().createFolder(path, autorename);
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_createfolder", true, new Object[] {true,result,"OK"});
				} catch (DbxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_createfolder", true, new Object[] {false,null,e.getMessage()});
				}
      }
		}).start();
	}
	public void createFolder(final String path){		
		new Thread(new Runnable() {
      @Override
      public void run() {
      	ba.Log("dummy()");
      	FolderMetadata result;
				try {
					result = getObject().createFolder(path);
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_createfolder", true, new Object[] {true,result,"OK"});
				} catch (DbxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_createfolder", true, new Object[] {false,null,e.getMessage()});
				}
      }
		}).start();
	}
	public void getcopyReference(final String path){		
		new Thread(new Runnable() {
      @Override
      public void run() {
      	ba.Log("getcopyReference()");
      	try {
					GetCopyReferenceResult result = getObject().copyReferenceGet(path);
					Map m = new Map();
					m.Initialize();

					m.Put("CopyReference", result.getCopyReference());
					m.Put("Expires", result.getExpires().getTime());
					m.Put("Metadata", result.getMetadata());
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_CopyReference", true, new Object[] {m});
				} catch (DbxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
      }
		}).start();
	}
	public void copyBatchCheck(final String batchID){		
		new Thread(new Runnable() {
      @Override
      public void run() {
      	ba.Log("dummy()");
      	RelocationBatchJobStatus result;
				try {
					result = getObject().copyBatchCheck(batchID);
					Map m = new Map();
					m.Initialize();

					m.Put("isInProgress", result.isInProgress());
					m.Put("isComplete", result.isComplete());
					m.Put("isFailed", result.isFailed());
					if (result.isFailed() == true){
						Map err = new Map();
						err.Initialize();

						RelocationBatchError failed = result.getFailedValue();
						err.Put("FromLookup", failed.getFromLookupValue().toString() );
						err.Put("FromWrite", failed.getFromWriteValue().toString() );
						err.Put("To", failed.getToValue().toString() );
						err.Put("isCantCopySharedFolder", failed.isCantCopySharedFolder() );
						err.Put("isCantMoveFolderIntoItself", failed.isCantMoveFolderIntoItself() );
						err.Put("isCantNestSharedFolder", failed.isCantNestSharedFolder() );
						err.Put("isDuplicatedOrNestedPaths", failed.isDuplicatedOrNestedPaths() );
						err.Put("isFromLookup", failed.isFromLookup() );
						err.Put("isFromWrite", failed.isFromWrite() );
						err.Put("isOther", failed.isOther() );
						err.Put("isTo", failed.isTo() );
						err.Put("isTooManyFiles", failed.isTooManyFiles() );
						err.Put("isTooManyWriteOperations", failed.isTooManyWriteOperations() );
						m.Put("FailedInfo", err);
					}
					if (result.isComplete() == true){
						m.Put("Entries", result.getCompleteValue().getEntries());						
					}
					m.Put("Tag", result.tag());
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_copybatchcheck", true, new Object[] {true,m,"batchchecked"});
				} catch (DbxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_copybatchcheck", true, new Object[] {false,null,e.getMessage()});
				}
      }
		}).start();
	}
	public void copyBatch(final java.util.List<RelocationPath> entries){		
		new Thread(new Runnable() {
      @Override
      public void run() {
      	ba.Log("dummy()");
      	LaunchEmptyResult result;
				try {
					result = getObject().copyBatch(entries);
					Map m = new Map();
					m.Initialize();
					m.Put("AsyncJobId", result.getAsyncJobIdValue());
					m.Put("isAsyncJobId", result.isAsyncJobId());
					m.Put("isComplete", result.isComplete());
					m.Put("Tag", result.tag());
					m.Put("Entries", entries);
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_copybatch", true, new Object[] {true,m,"batchcreated"});
				} catch (DbxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_copybatch", true, new Object[] {false,null,e.getMessage()});
				}
      }
		}).start();
	}
	public void restore(final String path, final String rev){		
		new Thread(new Runnable() {
      @Override
      public void run() {
      	ba.Log("restore()");
      	try {
					FileMetadata result = getObject().restore(path, rev);
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_restore", true, new Object[] {true,result,"OK"});
				} catch (DbxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_restore", true, new Object[] {false,null,e.getMessage()});
				}
      }
		}).start();
	}	
	public void search(final String path, final String query, final String mode, final long maxResults, final long startAt){		
		new Thread(new Runnable() {
      @Override
      public void run() {
      	ba.Log("search()");
      	SearchResult result;
				try {
					
					
					result = getObject().searchBuilder(path, query).withMode(SearchMode.valueOf(mode)).withMaxResults(maxResults).withStart(startAt).start();
					java.util.List<SearchMatch> res = result.getMatches();
					List l = new List();
	    		l.Initialize();
	    		for (SearchMatch match: res){
	    			Map m = new Map();
	    			m.Initialize();
	    			m.Put("MatchType", match.getMatchType().toString());
	    			m.Put("Metadata", match.getMetadata());
	    			l.Add(m);
	    		}					
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_search", true, new Object[] {l});
				} catch (DbxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
      }
		}).start();
	}
	public void upload(final String localPath, final String localFilename, final String destination, final boolean AutoRename, final boolean mute) throws FileNotFoundException, UploadErrorException, DbxException {		
		new Thread(new Runnable() {
      @Override
      public void run() {
      	ba.Log("upload()");
      	File localFile = new File(localPath, localFilename);
      	InputStream in;
				try {
					in = new FileInputStream(localFile);
	      	FileMetadata metadata = getObject().
	      			uploadBuilder(destination).
	      			withMode(WriteMode.ADD).withAutorename(AutoRename).withMute(mute).
	      			withClientModified(new Date(localFile.lastModified())).
	      			uploadAndFinish(in);
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_uploadfinished", true, new Object[] {true,AbsObjectWrapper.ConvertToWrapper(new FileMetadataWrapper(), metadata),"OK"});
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_uploadfinished", true, new Object[] {false,null,e.getMessage()});
				} catch (UploadErrorException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_uploadfinished", true, new Object[] {false,null,e.getMessage()});
				} catch (DbxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_uploadfinished", true, new Object[] {false,null,e.getMessage()});
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_uploadfinished", true, new Object[] {false,null,e.getMessage()});
				}
      }
		}).start();
	}
	public DownloadBuilder getDownloadbuilder(final String path){
		return getObject().downloadBuilder(path);
	}
	/**
	 * Downloads the file "path" and store it in the 
	 * path "localPath" under the filename "localFilename".
	 * DEV:Tested
	 */
	public void download(final String path,final String localPath, final String localFilename) {		
		new Thread(new Runnable() {
      @Override
      public void run() {
      	ba.Log("files.download()");
      	File localFile = new File(localPath, localFilename);
      	ba.Log("files.download(after new File())");
      	//OutputStream out = new OutputStream();
      	FileOutputStream fos = null;
//				try {
      	ba.Log("files.download(create fos)");
      	try {
      		fos = new FileOutputStream(localFile);
        	ba.Log("files.download(fos created)");
      		DbxDownloader<FileMetadata> result = null;
					try {
						result = getObject().downloadBuilder(path).start();
		      	ba.Log("files.download(got DbxDownloader<FileMetadata> result)");
						FileMetadata meta;
						try {
							meta = result.download(fos);
			      	ba.Log("files.download(after download");
							ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_downloadfinished", true, new Object[] {true, AbsObjectWrapper.ConvertToWrapper(new FileMetadataWrapper(), meta),"OK"});
						} catch (DbxException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} catch (DownloadErrorException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (DbxException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

      	} catch (FileNotFoundException e) {
      		// TODO Auto-generated catch block
      		e.printStackTrace();
      	}
      }
		}).start();
	}
	/**
	 * Downloads the file "path" with the revision "rev" and store it 
	 * in the path "localPath" under the filename "localFilename".
	 * DEV:NOT Tested
	 */
	public void download2(final String path,final String rev, final String localPath, final String localFilename) {		
		new Thread(new Runnable() {
      @Override
      public void run() {
      	ba.Log("files.download2()");
      	File localFile = new File(localPath, localFilename);
      	ba.Log("files.download2(after new File())");
      	//OutputStream out = new OutputStream();
      	FileOutputStream fos = null;
//				try {
      	ba.Log("files.download2(create fos)");
      	try {
      		fos = new FileOutputStream(localFile);
        	ba.Log("files.download2(fos created)");
      		DbxDownloader<FileMetadata> result = null;
					try {
						result = getObject().downloadBuilder(path).withRev(rev).start();
		      	ba.Log("files.download(got DbxDownloader<FileMetadata> result)");
						FileMetadata meta;
						try {
							meta = result.download(fos);
			      	ba.Log("files.download(after download");
							ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_downloadfinished", true, new Object[] {true, AbsObjectWrapper.ConvertToWrapper(new FileMetadataWrapper(), meta),"OK"});
						} catch (DbxException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} catch (DownloadErrorException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (DbxException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

      	} catch (FileNotFoundException e) {
      		// TODO Auto-generated catch block
      		e.printStackTrace();
      	}
      }
		}).start();
	}


	
	public void listFolderLatestCursor(final BA pba, final String path,final boolean includeDeleted, final boolean includeHasExplicitSharedMembers, final boolean includeMediaInfo, final boolean recursive, final boolean debuglog) throws DbxException{		
		new Thread(new Runnable() {
      @Override
      public void run() {
      	if (debuglog == true){
      		ba.Log("files.listFolderLatestCursor()");
      	}
				List l = new List();
    		l.Initialize();

      	ListFolderGetLatestCursorResult result;
				try {
					result = getObject().listFolderGetLatestCursorBuilder(path).withIncludeDeleted(includeDeleted).withIncludeHasExplicitSharedMembers(includeHasExplicitSharedMembers).withIncludeMediaInfo(includeMediaInfo).withRecursive(recursive).start();
					//	result = getObject().listFolder(path);
					//pba.Log("files:listFolder(result filled)");
					ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_latestcursor", true, new Object[] {true, path, result.getCursor(),"OK"});
				} catch (ListFolderErrorException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_latestcursor", true, new Object[] {false,path, "",e.getMessage()});
				} catch (DbxException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_latestcursor", true, new Object[] {false,path, "",e.getMessage()});
				}
      }
		}).start();
	}

	
	/**
	 * Lists the content from path "path"
	 * - If "includeDeleted" is set to true then deleted 
	 * files/folders are listed too. See Metadata for 
	 * details on each entry.
	 * 
	 * - is "includeHasExplicitSharedMembers" is set to 
	 * true then "i dont know what happens ;) See 
	 * Dropbox site for more info ;-)
	 * 
	 * - if "includeMediaInfo" is set to true then the 
	 * result will ontain MediaInfo too (pictures and video)
	 * 
	 * - If "recursive" is set to true then the Folder will 
	 * be listed recursively. Note that this could result in 
	 * a long list of Metadatas.
	 * 
	 * - If "debuglog" is set to true then the lib will do 
	 * some LOG-Output so see where it hangs
	 * 
	 * DEV:Tested!
	 */
	public void listFolder(final BA pba, final String path,final boolean includeDeleted, final boolean includeHasExplicitSharedMembers, final boolean includeMediaInfo, final boolean recursive, final boolean debuglog) throws DbxException{		
		new Thread(new Runnable() {
      @Override
      public void run() {
      	if (debuglog == true){
      		ba.Log("files:listFolder()");
      	}
				List l = new List();
    		l.Initialize();

      	ListFolderResult result;
				try {
					result = getObject().listFolderBuilder(path).withIncludeDeleted(includeDeleted).withIncludeHasExplicitSharedMembers(includeHasExplicitSharedMembers).withIncludeMediaInfo(includeMediaInfo).withRecursive(recursive).start();
					//	result = getObject().listFolder(path);
					//pba.Log("files:listFolder(result filled)");
					while (true) {
						//pba.Log("files:listFolder(while)");
						for (Metadata metadata : result.getEntries()) {
							//pba.Log("listFolder(l.add(meta))");
							l.Add(metadata);
						}	
						if (!result.getHasMore()) {
							break;
						}
		      	if (debuglog == true){
		      		ba.Log("files:listFolderContinue("+result.getCursor()+")");
		      	}
						result = getObject().listFolderContinue(result.getCursor());
						//pba.Log("files:listFolder(result filled)");
					}
					ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_listfolder", true, new Object[] {true,l,"OK"});
				} catch (ListFolderErrorException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_listfolder", true, new Object[] {false,l,e.getMessage()});
				} catch (DbxException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_listfolder", true, new Object[] {false,l,e.getMessage()});
				}
      }
		}).start();
	}
	@Hide
	public void listFolderContinue(final String cursor){		
		new Thread(new Runnable() {
      @Override
      public void run() {
      	ba.Log("listFolderContinue()");
      	ListFolderResult result;
				try {
					result = getObject().listFolderContinue(cursor);
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_listfoldercontinue", true, new Object[] {result});
				} catch (DbxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
      }
		}).start();
	}
	/**
	 * Returns the metadata for a file or folder.
	 * Note: Metadata for the root folder is unsupported. 
	 * @param path
	 * DEV:not tested!
	 */	
	public void getMetadata(final String path, final boolean includeDeleted, final boolean includeHasExplicitSharedMembers, final boolean includeMediaInfo, final boolean debuglog){		
		new Thread(new Runnable() {
      @Override
      public void run() {
      	ba.Log("copy()");
      	Metadata result;
				try {
					result = getObject().getMetadataBuilder(path).withIncludeDeleted(includeDeleted).withIncludeHasExplicitSharedMembers(includeHasExplicitSharedMembers).withIncludeMediaInfo(includeMediaInfo).start();
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_metadata", true, new Object[] {AbsObjectWrapper.ConvertToWrapper(new MetadataWrapper(), result)});
				} catch (DbxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
      }
		}).start();
	}
	/**
	 * Copy a file or folder to a different location 
	 * in the user's Dropbox. If the source path is 
	 * a folder all its contents will be copied.
	 * @param fromPath
	 * @param toPath
	 * DEV:not tested!
	 */
	public void copy(final String fromPath,final String toPath){		
		new Thread(new Runnable() {
      @Override
      public void run() {
      	ba.Log("copy()");
      	Metadata result;
				try {
					result = getObject().copy(fromPath, toPath);
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_copy", true, new Object[] {true,AbsObjectWrapper.ConvertToWrapper(new MetadataWrapper(), result),"OK"});
				} catch (DbxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_copy", true, new Object[] {false,null,e.getMessage()});
				}
      }
		}).start();
	}

	
		
}
